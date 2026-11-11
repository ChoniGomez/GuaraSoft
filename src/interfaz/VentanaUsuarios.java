package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logicaDeNegocio.Sucursal;
import logicaDeNegocio.Usuario;
import persistenciaJPA.exceptions.PreexistingEntityException;

/**
 * Ventana de Administración de Usuarios, Roles, Permisos y Sucursales (Exclusivo Superusuario Master).
 */
public class VentanaUsuarios extends JInternalFrame {

    private final ControladoraInterfaz miLogica;
    private final DefaultTableModel modeloTabla;
    private int idUsuarioModificar = -1;
    private List<Sucursal> listaSucursales = new LinkedList<Sucursal>();

    private JTextField txtNombreUsuario;
    private JPasswordField txtContrasenia;
    private JTextField txtNombreCompleto;
    private JComboBox<String> cmbRol;
    private JComboBox<String> cmbSucursal;
    private JCheckBox chkActivo;

    // Permisos de módulos
    private JCheckBox chkPermisoABM;
    private JCheckBox chkPermisoEmpresa;
    private JCheckBox chkPermisoFacturacion;
    private JCheckBox chkPermisoClientes;
    private JCheckBox chkPermisoTurnos;
    private JCheckBox chkPermisoProyectos;
    private JCheckBox chkPermisoUsuarios;

    private JButton btnAceptar;
    private JButton btnCancelar;
    private JButton btnNuevo;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JTable tablaUsuarios;

    public VentanaUsuarios(ControladoraInterfaz controladora) {
        this.miLogica = controladora;
        this.modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        inicializarComponentes();
        cargarSucursales();
        cargarTablaUsuarios();
        activarFormulario(false);
    }

    private void inicializarComponentes() {
        setTitle("Administración de Usuarios, Roles y Permisos");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        JPanel panelContenedor = new JPanel(new BorderLayout(12, 12));
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // Panel Izquierdo: Datos y Permisos del Usuario
        JPanel panelIzquierdo = new JPanel(new BorderLayout(8, 8));
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Datos de Cuenta y Permisos"));

        JPanel panelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 6, 5, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNombreUsuario = new JTextField(15);
        txtContrasenia = new JPasswordField(15);
        txtNombreCompleto = new JTextField(15);
        cmbRol = new JComboBox<String>(new String[]{
            Usuario.ROL_SUPERUSUARIO,
            Usuario.ROL_GERENTE,
            Usuario.ROL_OPERADOR
        });
        cmbSucursal = new JComboBox<String>();
        chkActivo = new JCheckBox("Cuenta Activa", true);

        int fila = 0;
        agregarFilaCampo(panelCampos, gbc, fila++, "Usuario (Login):", txtNombreUsuario);
        agregarFilaCampo(panelCampos, gbc, fila++, "Contraseña:", txtContrasenia);
        agregarFilaCampo(panelCampos, gbc, fila++, "Nombre Completo:", txtNombreCompleto);
        agregarFilaCampo(panelCampos, gbc, fila++, "Rol del Sistema:", cmbRol);
        agregarFilaCampo(panelCampos, gbc, fila++, "Sucursal Asignada:", cmbSucursal);

        gbc.gridx = 1;
        gbc.gridy = fila++;
        panelCampos.add(chkActivo, gbc);

        // Subpanel de Permisos por Módulo
        JPanel panelPermisos = new JPanel(new GridLayout(0, 1, 4, 4));
        panelPermisos.setBorder(BorderFactory.createTitledBorder("Módulos Habilitados"));

        chkPermisoABM = new JCheckBox("Módulo Alta / Baja / Modificación");
        chkPermisoEmpresa = new JCheckBox("Módulo Empresa (Artículos, Empleados, Sucursales)");
        chkPermisoFacturacion = new JCheckBox("Módulo Facturación (Compras, Ventas, Tiques)");
        chkPermisoClientes = new JCheckBox("Módulo Clientes y Cuentas Corrientes");
        chkPermisoTurnos = new JCheckBox("Módulo Gestión de Turnos y Equipos");
        chkPermisoProyectos = new JCheckBox("Módulo Gestión de Proyectos y Cuotas");
        chkPermisoUsuarios = new JCheckBox("Administración de Usuarios y Seguridad");

        panelPermisos.add(chkPermisoABM);
        panelPermisos.add(chkPermisoEmpresa);
        panelPermisos.add(chkPermisoFacturacion);
        panelPermisos.add(chkPermisoClientes);
        panelPermisos.add(chkPermisoTurnos);
        panelPermisos.add(chkPermisoProyectos);
        panelPermisos.add(chkPermisoUsuarios);

        // Botones Aceptar / Cancelar
        JPanel panelAccionesForm = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 6));
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        panelAccionesForm.add(btnAceptar);
        panelAccionesForm.add(btnCancelar);

        panelIzquierdo.add(panelCampos, BorderLayout.NORTH);
        panelIzquierdo.add(panelPermisos, BorderLayout.CENTER);
        panelIzquierdo.add(panelAccionesForm, BorderLayout.SOUTH);

        // Panel Derecho: Tabla de Usuarios y Botones ABM
        JPanel panelDerecho = new JPanel(new BorderLayout(8, 8));
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Usuarios Registrados en el Sistema"));

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Usuario");
        modeloTabla.addColumn("Nombre Completo");
        modeloTabla.addColumn("Rol");
        modeloTabla.addColumn("Sucursal");
        modeloTabla.addColumn("Estado");

        tablaUsuarios = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaUsuarios);

        JPanel panelBotonesTabla = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));
        btnNuevo = new JButton("Nuevo");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        panelBotonesTabla.add(btnNuevo);
        panelBotonesTabla.add(btnModificar);
        panelBotonesTabla.add(btnEliminar);

        panelDerecho.add(scrollTabla, BorderLayout.CENTER);
        panelDerecho.add(panelBotonesTabla, BorderLayout.SOUTH);

        panelContenedor.add(panelIzquierdo, BorderLayout.WEST);
        panelContenedor.add(panelDerecho, BorderLayout.CENTER);

        setContentPane(panelContenedor);

        // Eventos de Rol para autocompletar permisos sugeridos
        cmbRol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicarPlantillaRol();
            }
        });

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idUsuarioModificar = -1;
                limpiarFormulario();
                activarFormulario(true);
                aplicarPlantillaRol();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idUsuarioModificar = -1;
                limpiarFormulario();
                activarFormulario(false);
            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarUsuario();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarUsuarioParaModificar();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuarioSeleccionado();
            }
        });

        pack();
    }

    private void agregarFilaCampo(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, java.awt.Component campo) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        gbc.gridy = fila;
        gbc.weightx = 1.0;
        panel.add(campo, gbc);
    }

    private void aplicarPlantillaRol() {
        if (!cmbRol.isEnabled()) {
            return;
        }
        String rol = (String) cmbRol.getSelectedItem();
        if (Usuario.ROL_SUPERUSUARIO.equals(rol)) {
            chkPermisoABM.setSelected(true);
            chkPermisoEmpresa.setSelected(true);
            chkPermisoFacturacion.setSelected(true);
            chkPermisoClientes.setSelected(true);
            chkPermisoTurnos.setSelected(true);
            chkPermisoProyectos.setSelected(true);
            chkPermisoUsuarios.setSelected(true);
            cmbSucursal.setSelectedIndex(0);
        } else if (Usuario.ROL_GERENTE.equals(rol)) {
            chkPermisoABM.setSelected(true);
            chkPermisoEmpresa.setSelected(true);
            chkPermisoFacturacion.setSelected(true);
            chkPermisoClientes.setSelected(true);
            chkPermisoTurnos.setSelected(true);
            chkPermisoProyectos.setSelected(true);
            chkPermisoUsuarios.setSelected(false);
        } else {
            chkPermisoABM.setSelected(false);
            chkPermisoEmpresa.setSelected(false);
            chkPermisoFacturacion.setSelected(true);
            chkPermisoClientes.setSelected(true);
            chkPermisoTurnos.setSelected(true);
            chkPermisoProyectos.setSelected(false);
            chkPermisoUsuarios.setSelected(false);
        }
    }

    private void cargarSucursales() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        model.addElement("Todas las Sucursales (Global)");
        try {
            listaSucursales = miLogica.dameSucursales();
            for (Sucursal s : listaSucursales) {
                model.addElement("Sucursal N° " + s.getNumeroSucursal() + " - " + s.getDireccion());
            }
        } catch (PreexistingEntityException ex) {
            ex.printStackTrace();
        }
        cmbSucursal.setModel(model);
    }

    private Sucursal obtenerSucursalSeleccionada() {
        int index = cmbSucursal.getSelectedIndex();
        if (index <= 0 || index - 1 >= listaSucursales.size()) {
            return null;
        }
        return listaSucursales.get(index - 1);
    }

    private void cargarTablaUsuarios() {
        modeloTabla.setRowCount(0);
        List<Usuario> usuarios = miLogica.dameUsuarios();
        for (Usuario u : usuarios) {
            String sucTexto = u.getSucursalAsignada() != null
                    ? "Sucursal " + u.getSucursalAsignada().getNumeroSucursal()
                    : "Todas (Global)";
            String estado = u.isActivo() ? "Activo" : "Inactivo";
            if (u.isEsMasterInborrable()) {
                estado = "MASTER (Protegido)";
            }
            modeloTabla.addRow(new Object[]{
                u.getIdUsuario(),
                u.getNombreUsuario(),
                u.getNombreCompleto(),
                u.getRol(),
                sucTexto,
                estado
            });
        }
    }

    private void activarFormulario(boolean activo) {
        txtNombreUsuario.setEnabled(activo);
        txtContrasenia.setEnabled(activo);
        txtNombreCompleto.setEnabled(activo);
        cmbRol.setEnabled(activo);
        cmbSucursal.setEnabled(activo);
        chkActivo.setEnabled(activo);
        chkPermisoABM.setEnabled(activo);
        chkPermisoEmpresa.setEnabled(activo);
        chkPermisoFacturacion.setEnabled(activo);
        chkPermisoClientes.setEnabled(activo);
        chkPermisoTurnos.setEnabled(activo);
        chkPermisoProyectos.setEnabled(activo);
        chkPermisoUsuarios.setEnabled(activo);
        btnAceptar.setEnabled(activo);
        btnCancelar.setEnabled(activo);
    }

    private void limpiarFormulario() {
        txtNombreUsuario.setText("");
        txtContrasenia.setText("");
        txtNombreCompleto.setText("");
        cmbRol.setSelectedIndex(2); // Operador por defecto
        if (cmbSucursal.getItemCount() > 0) {
            cmbSucursal.setSelectedIndex(0);
        }
        chkActivo.setSelected(true);
        chkPermisoABM.setSelected(false);
        chkPermisoEmpresa.setSelected(false);
        chkPermisoFacturacion.setSelected(false);
        chkPermisoClientes.setSelected(false);
        chkPermisoTurnos.setSelected(false);
        chkPermisoProyectos.setSelected(false);
        chkPermisoUsuarios.setSelected(false);
    }

    private void guardarUsuario() {
        String login = txtNombreUsuario.getText().trim();
        String pass = new String(txtContrasenia.getPassword());
        String nombre = txtNombreCompleto.getText().trim();
        String rol = (String) cmbRol.getSelectedItem();
        Sucursal sucursal = obtenerSucursalSeleccionada();

        if (login.isEmpty() || pass.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete Usuario, Contraseña y Nombre Completo.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (idUsuarioModificar == -1) {
                miLogica.crearUsuario(
                        login, pass, nombre, rol, sucursal,
                        chkPermisoABM.isSelected(),
                        chkPermisoEmpresa.isSelected(),
                        chkPermisoFacturacion.isSelected(),
                        chkPermisoClientes.isSelected(),
                        chkPermisoTurnos.isSelected(),
                        chkPermisoProyectos.isSelected(),
                        chkPermisoUsuarios.isSelected()
                );
                JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                miLogica.modificarUsuario(
                        idUsuarioModificar, login, pass, nombre, rol, chkActivo.isSelected(), sucursal,
                        chkPermisoABM.isSelected(),
                        chkPermisoEmpresa.isSelected(),
                        chkPermisoFacturacion.isSelected(),
                        chkPermisoClientes.isSelected(),
                        chkPermisoTurnos.isSelected(),
                        chkPermisoProyectos.isSelected(),
                        chkPermisoUsuarios.isSelected()
                );
                JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            idUsuarioModificar = -1;
            limpiarFormulario();
            activarFormulario(false);
            cargarTablaUsuarios();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarUsuarioParaModificar() {
        int fila = tablaUsuarios.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la tabla para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = Integer.parseInt(tablaUsuarios.getValueAt(fila, 0).toString());
        Usuario u = miLogica.dameMiUsuario(id);
        if (u == null) {
            return;
        }

        idUsuarioModificar = u.getIdUsuario();
        activarFormulario(true);

        txtNombreUsuario.setText(u.getNombreUsuario());
        txtContrasenia.setText(u.getContrasenia());
        txtNombreCompleto.setText(u.getNombreCompleto());
        cmbRol.setSelectedItem(u.getRol());
        chkActivo.setSelected(u.isActivo());

        if (u.getSucursalAsignada() == null) {
            cmbSucursal.setSelectedIndex(0);
        } else {
            for (int i = 0; i < listaSucursales.size(); i++) {
                if (listaSucursales.get(i).getIdSucursal() == u.getSucursalAsignada().getIdSucursal()) {
                    cmbSucursal.setSelectedIndex(i + 1);
                    break;
                }
            }
        }

        chkPermisoABM.setSelected(u.isPermisoABM());
        chkPermisoEmpresa.setSelected(u.isPermisoEmpresa());
        chkPermisoFacturacion.setSelected(u.isPermisoFacturacion());
        chkPermisoClientes.setSelected(u.isPermisoClientes());
        chkPermisoTurnos.setSelected(u.isPermisoTurnos());
        chkPermisoProyectos.setSelected(u.isPermisoProyectos());
        chkPermisoUsuarios.setSelected(u.isPermisoUsuarios());

        // Si es el Master Desarrollador, bloquear cambio de nombre de usuario, rol o desactivación
        if (u.isEsMasterInborrable()) {
            txtNombreUsuario.setEnabled(false);
            cmbRol.setEnabled(false);
            cmbSucursal.setEnabled(false);
            chkActivo.setEnabled(false);
            chkPermisoABM.setEnabled(false);
            chkPermisoEmpresa.setEnabled(false);
            chkPermisoFacturacion.setEnabled(false);
            chkPermisoClientes.setEnabled(false);
            chkPermisoTurnos.setEnabled(false);
            chkPermisoProyectos.setEnabled(false);
            chkPermisoUsuarios.setEnabled(false);
        }
    }

    private void eliminarUsuarioSeleccionado() {
        int fila = tablaUsuarios.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = Integer.parseInt(tablaUsuarios.getValueAt(fila, 0).toString());
        Usuario u = miLogica.dameMiUsuario(id);
        if (u != null && u.isEsMasterInborrable()) {
            JOptionPane.showMessageDialog(this, "El Superusuario Master está protegido y no puede ser eliminado.", "Operación Bloqueada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea eliminar al usuario '" + tablaUsuarios.getValueAt(fila, 1) + "'?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                miLogica.eliminarUsuario(id);
                cargarTablaUsuarios();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
