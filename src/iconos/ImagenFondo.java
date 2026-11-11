package iconos;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class ImagenFondo implements Border {
    private BufferedImage back;

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
        if (back != null) {
            g.drawImage(back, x + (width - back.getWidth()) / 2, y + (height - back.getHeight()) / 2, null);
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
