package interfaz;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

public class EstiloModerno {

    private static boolean modoOscuro = true;

    // Colores personalizados para bordes nítidos y fondos contrastantes
    public static final Color COLOR_BORDE_INPUT_OSCURO = new Color(75, 85, 99);   // Gris pizarra visible
    public static final Color COLOR_BORDE_INPUT_CLARO = new Color(209, 213, 219);
    public static final Color COLOR_FOCUS = new Color(59, 130, 246);              // Azul moderno
    public static final Color COLOR_FONDO_INPUT_OSCURO = new Color(38, 42, 51);

    public static void inicializarLookAndFeel() {
        try {
            // Curvaturas y geometría
            UIManager.put("Button.arc", 8);
            UIManager.put("Component.arc", 6);
            UIManager.put("TextComponent.arc", 6);
            UIManager.put("Component.focusWidth", 1);
            UIManager.put("Component.innerFocusWidth", 0);

            // Márgenes y padding interno generoso para inputs y botones
            UIManager.put("TextField.margin", new Insets(4, 8, 4, 8));
            UIManager.put("PasswordField.margin", new Insets(4, 8, 4, 8));
            UIManager.put("TextArea.margin", new Insets(6, 8, 6, 8));
            UIManager.put("Button.margin", new Insets(6, 14, 6, 14));

            // Barras de desplazamiento
            UIManager.put("ScrollBar.showButtons", false);
            UIManager.put("ScrollBar.thumbArc", 999);
            UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));

            // Tablas
            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.showVerticalLines", false);
            UIManager.put("Table.intercellSpacing", new Dimension(0, 1));
            UIManager.put("Table.selectionArc", 6);

            // Ventana principal y marcos internos
            UIManager.put("TitlePane.unifiedBackground", true);
            UIManager.put("InternalFrame.buttonSize", new Dimension(24, 24));
            UIManager.put("InternalFrameTitlePane.buttonSpacing", 2);

            // Colores de borde y contraste para campos de entrada
            if (modoOscuro) {
                UIManager.put("Component.borderColor", COLOR_BORDE_INPUT_OSCURO);
                UIManager.put("Component.focusedBorderColor", COLOR_FOCUS);
                UIManager.put("TextField.background", COLOR_FONDO_INPUT_OSCURO);
                UIManager.put("PasswordField.background", COLOR_FONDO_INPUT_OSCURO);
                UIManager.put("ComboBox.background", COLOR_FONDO_INPUT_OSCURO);
                FlatDarkLaf.setup();
            } else {
                UIManager.put("Component.borderColor", COLOR_BORDE_INPUT_CLARO);
                UIManager.put("Component.focusedBorderColor", COLOR_FOCUS);
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
            aplicarEstiloComponentes(frame.getContentPane());
            return;
        }
        aplicarEstiloComponentes(contenedor);
    }

    private static void aplicarEstiloComponentes(Container contenedor) {
        if (contenedor instanceof BasicInternalFrameTitlePane) {
            return;
        }

        Color colorBorde = modoOscuro ? COLOR_BORDE_INPUT_OSCURO : COLOR_BORDE_INPUT_CLARO;

        for (Component comp : contenedor.getComponents()) {
            if (comp instanceof BasicInternalFrameTitlePane) {
                continue;
            }

            if (comp instanceof JButton) {
                estilizarBoton((JButton) comp);
            } else if (comp instanceof JTextField || comp instanceof JPasswordField) {
                JTextField txt = (JTextField) comp;
                txt.setPreferredSize(new Dimension(Math.max(txt.getPreferredSize().width, 160), 32));
                txt.putClientProperty("JTextField.showClearButton", true);
                
                // Borde nítido exterior con padding interno para evitar texto pegado al borde
                Border bordeCompuesto = BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(colorBorde, 1, true),
                    BorderFactory.createEmptyBorder(3, 8, 3, 8)
                );
                txt.setBorder(bordeCompuesto);
            } else if (comp instanceof JTextArea) {
                JTextArea area = (JTextArea) comp;
                Border bordeArea = BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(colorBorde, 1, true),
                    BorderFactory.createEmptyBorder(6, 8, 6, 8)
                );
                area.setBorder(bordeArea);
            } else if (comp instanceof JComboBox) {
                JComboBox<?> combo = (JComboBox<?>) comp;
                combo.setPreferredSize(new Dimension(Math.max(combo.getPreferredSize().width, 160), 32));
                combo.setBorder(BorderFactory.createLineBorder(colorBorde, 1, true));
            } else if (comp instanceof JTable) {
                JTable tabla = (JTable) comp;
                tabla.setRowHeight(28);
                tabla.getTableHeader().setFont(tabla.getTableHeader().getFont().deriveFont(Font.BOLD));
                tabla.getTableHeader().setPreferredSize(new Dimension(tabla.getTableHeader().getWidth(), 32));
                tabla.setFillsViewportHeight(true);
            }

            // TitledBorder: margen interno generoso para que Aceptar/Cancelar y campos NO choquen con el borde
            if (comp instanceof JComponent) {
                JComponent jcomp = (JComponent) comp;
                if (jcomp.getBorder() instanceof TitledBorder) {
                    TitledBorder tb = (TitledBorder) jcomp.getBorder();
                    tb.setTitleFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 12f));
                    jcomp.setBorder(BorderFactory.createCompoundBorder(
                        tb,
                        BorderFactory.createEmptyBorder(12, 14, 16, 14) // Padding generoso abajo para evitar encimamiento de botones
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
