package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logicaDeNegocio.SesionUsuario;
import logicaDeNegocio.Usuario;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

/**
 * Ventana de Inicio de Sesión empresarial para GuaraSoft.
 */
public class VentanaLogin extends JFrame {

    private final ControladoraInterfaz miLogica;
    private JTextField txtUsuario;
    private JPasswordField txtContrasenia;
    private JButton btnIngresar;
    private JButton btnSalir;

    public VentanaLogin() {
        this.miLogica = new ControladoraInterfaz();
        inicializarComponentes();
        EstiloModerno.aplicarEstiloVentana(this);
    }

    private void inicializarComponentes() {
        setTitle("GuaraSoft - Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panelPrincipal = new JPanel(new BorderLayout(0, 15));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(25, 35, 25, 35));

        // Encabezado con icono y título
        JPanel panelEncabezado = new JPanel(new BorderLayout(0, 8));
        JLabel lblIcono = new JLabel();
        lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
        lblIcono.setIcon(FontIcon.of(FontAwesomeSolid.SHIELD_ALT, 46, new Color(52, 152, 219)));

        JLabel lblTitulo = new JLabel("GuaraSoft", SwingConstants.CENTER);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 24f));

        JLabel lblSubtitulo = new JLabel("Control de Acceso y Gestión Empresarial", SwingConstants.CENTER);
        lblSubtitulo.setFont(lblSubtitulo.getFont().deriveFont(Font.PLAIN, 12f));
        lblSubtitulo.setForeground(new Color(150, 150, 150));

        panelEncabezado.add(lblIcono, BorderLayout.NORTH);
        panelEncabezado.add(lblTitulo, BorderLayout.CENTER);
        panelEncabezado.add(lblSubtitulo, BorderLayout.SOUTH);

        // Formulario central
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Credenciales de Usuario"),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setIcon(FontIcon.of(FontAwesomeSolid.USER, 14, new Color(100, 181, 246)));
        txtUsuario = new JTextField(18);
        txtUsuario.setText("admin");

        JLabel lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setIcon(FontIcon.of(FontAwesomeSolid.LOCK, 14, new Color(100, 181, 246)));
        txtContrasenia = new JPasswordField(18);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panelFormulario.add(lblUsuario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        panelFormulario.add(txtUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panelFormulario.add(lblContrasenia, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        panelFormulario.add(txtContrasenia, gbc);

        // Botones inferiores
        JPanel panelBotones = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.insets = new Insets(5, 8, 5, 8);

        btnIngresar = new JButton("Ingresar");
        btnSalir = new JButton("Salir");

        gbcBtn.gridx = 0;
        gbcBtn.gridy = 0;
        panelBotones.add(btnIngresar, gbcBtn);

        gbcBtn.gridx = 1;
        gbcBtn.gridy = 0;
        panelBotones.add(btnSalir, gbcBtn);

        panelPrincipal.add(panelEncabezado, BorderLayout.NORTH);
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
        getRootPane().setDefaultButton(btnIngresar);

        // Eventos
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intentarLogin();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setPreferredSize(new Dimension(440, 360));
        pack();
    }

    private void intentarLogin() {
        String usuario = txtUsuario.getText().trim();
        String pass = new String(txtContrasenia.getPassword());

        if (usuario.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingrese su usuario y contraseña.",
                    "Campos requeridos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Usuario autenticado = miLogica.autenticarUsuario(usuario, pass);
        if (autenticado != null) {
            SesionUsuario.getInstancia().iniciarSesion(autenticado);
            VentanaEmpresaPrincipal principal = new VentanaEmpresaPrincipal();
            principal.setLocationRelativeTo(null);
            principal.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos, o cuenta deshabilitada.",
                    "Acceso Denegado",
                    JOptionPane.ERROR_MESSAGE);
            txtContrasenia.setText("");
            txtContrasenia.requestFocus();
        }
    }
}
