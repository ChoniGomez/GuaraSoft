package interfaz;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

public class EstiloModerno {

    private static boolean modoOscuro = true;

    public static void inicializarLookAndFeel() {
        try {
            UIManager.put("Button.arc", 10);
            UIManager.put("Component.arc", 8);
            UIManager.put("TextComponent.arc", 8);
            UIManager.put("ScrollBar.showButtons", false);
            UIManager.put("ScrollBar.thumbArc", 999);
            UIManager.put("ScrollBar.thumbInsets", new java.awt.Insets(2, 2, 2, 2));
            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.showVerticalLines", false);
            UIManager.put("Table.intercellSpacing", new Dimension(0, 1));
            UIManager.put("Table.selectionArc", 8);
            UIManager.put("TitlePane.unifiedBackground", true);
            // Asegurar diseño estándar de los botones de JInternalFrame en la esquina superior derecha
            UIManager.put("InternalFrame.buttonSize", new Dimension(24, 24));
            UIManager.put("InternalFrameTitlePane.buttonSpacing", 2);

            if (modoOscuro) {
                FlatDarkLaf.setup();
            } else {
                FlatLightLaf.setup();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void alternarTema(Component ventanaRaiz) {
        modoOscuro = !modoOscuro;
        inicializarLookAndFeel();
        SwingUtilities.updateComponentTreeUI(ventanaRaiz);
    }

    public static boolean esModoOscuro() {
        return modoOscuro;
    }

    public static void aplicarEstiloVentana(Container contenedor) {
        if (contenedor instanceof JInternalFrame) {
            JInternalFrame frame = (JInternalFrame) contenedor;
            frame.setClosable(true);
            frame.setIconifiable(true);
            frame.setMaximizable(true);
            frame.setResizable(true);
            frame.putClientProperty("JInternalFrame.isPalette", false);
            // Solo estilizar el ContentPane para NO alterar los controles de minimizar/maximizar/cerrar del marco
            aplicarEstiloComponentes(frame.getContentPane());
            return;
        }
        aplicarEstiloComponentes(contenedor);
    }

    private static void aplicarEstiloComponentes(Container contenedor) {
        if (contenedor instanceof BasicInternalFrameTitlePane) {
            return;
        }

        for (Component comp : contenedor.getComponents()) {
            if (comp instanceof BasicInternalFrameTitlePane) {
                continue;
            }

            if (comp instanceof JButton) {
                estilizarBoton((JButton) comp);
            } else if (comp instanceof JTextField || comp instanceof JPasswordField) {
                JTextField txt = (JTextField) comp;
                txt.setPreferredSize(new Dimension(Math.max(txt.getPreferredSize().width, 160), 30));
                txt.putClientProperty("JTextField.showClearButton", true);
            } else if (comp instanceof JComboBox) {
                JComboBox<?> combo = (JComboBox<?>) comp;
                combo.setPreferredSize(new Dimension(Math.max(combo.getPreferredSize().width, 160), 30));
            } else if (comp instanceof JTable) {
                JTable tabla = (JTable) comp;
                tabla.setRowHeight(28);
                tabla.getTableHeader().setFont(tabla.getTableHeader().getFont().deriveFont(Font.BOLD));
                tabla.getTableHeader().setPreferredSize(new Dimension(tabla.getTableHeader().getWidth(), 32));
                tabla.setFillsViewportHeight(true);
            }

            if (comp instanceof JComponent) {
                JComponent jcomp = (JComponent) comp;
                if (jcomp.getBorder() instanceof TitledBorder) {
                    TitledBorder tb = (TitledBorder) jcomp.getBorder();
                    tb.setTitleFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 13f));
                    jcomp.setBorder(BorderFactory.createCompoundBorder(
                        tb,
                        BorderFactory.createEmptyBorder(8, 10, 8, 10)
                    ));
                }
            }

            if (comp instanceof Container) {
                aplicarEstiloComponentes((Container) comp);
            }
        }
    }

    private static void estilizarBoton(JButton btn) {
        String texto = btn.getText() != null ? btn.getText().trim().toLowerCase() : "";
        if (texto.isEmpty()) {
            return;
        }
        btn.setIconTextGap(8);
        btn.setFont(btn.getFont().deriveFont(Font.BOLD, 12f));
        btn.setPreferredSize(new Dimension(Math.max(btn.getPreferredSize().width + 24, 115), 34));

        if (texto.contains("nuevo") || texto.contains("agregar") || texto.equals("+")) {
            btn.setIcon(FontIcon.of(FontAwesomeSolid.PLUS_CIRCLE, 14, new Color(46, 204, 113)));
        } else if (texto.contains("modificar") || texto.contains("editar")) {
            btn.setIcon(FontIcon.of(FontAwesomeSolid.EDIT, 14, new Color(52, 152, 219)));
        } else if (texto.contains("eliminar") || texto.contains("borrar") || texto.contains("quitar") || texto.equals("-")) {
            btn.setIcon(FontIcon.of(FontAwesomeSolid.TRASH_ALT, 14, new Color(231, 76, 60)));
        } else if (texto.contains("aceptar") || texto.contains("guardar") || texto.contains("ingresar")) {
            btn.setIcon(FontIcon.of(FontAwesomeSolid.CHECK, 14, new Color(46, 204, 113)));
            btn.putClientProperty("JButton.buttonType", "roundRect");
        } else if (texto.contains("cancelar") || texto.contains("salir")) {
            btn.setIcon(FontIcon.of(FontAwesomeSolid.TIMES, 14, new Color(231, 76, 60)));
        } else if (texto.contains("buscar")) {
            btn.setIcon(FontIcon.of(FontAwesomeSolid.SEARCH, 14, new Color(155, 89, 182)));
        }
    }
}
