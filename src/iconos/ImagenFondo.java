package iconos;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class ImagenFondo implements Border {
    private BufferedImage back;
    private Image imagenEscalada;
    private int ultimoAncho = -1;
    private int ultimoAlto = -1;

    public ImagenFondo() {
        try (InputStream is = getClass().getResourceAsStream("/iconos/software.jpg")) {
            if (is != null) {
                back = ImageIO.read(is);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (back != null && width > 0 && height > 0) {
            // Calculamos el escalado proporcional para que no se deforme y quepa en la ventana
            double proporcionImagen = (double) back.getWidth() / back.getHeight();
            double proporcionPanel = (double) width / height;

            int nuevoAncho;
            int nuevoAlto;

            if (proporcionPanel > proporcionImagen) {
                // Ajustar por ancho/alto para cubrir o contener proporcionalmente
                nuevoAncho = width;
                nuevoAlto = (int) (width / proporcionImagen);
            } else {
                nuevoAlto = height;
                nuevoAncho = (int) (height * proporcionImagen);
            }

            // Cacheamos la instancia escalada con SCALE_SMOOTH para que no ralentice al mover ventanas internas
            if (imagenEscalada == null || ultimoAncho != nuevoAncho || ultimoAlto != nuevoAlto) {
                imagenEscalada = back.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                ultimoAncho = nuevoAncho;
                ultimoAlto = nuevoAlto;
            }

            int posX = x + (width - nuevoAncho) / 2;
            int posY = y + (height - nuevoAlto) / 2;

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(imagenEscalada, posX, posY, c);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
