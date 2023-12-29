/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import logicaDeNegocio.Cliente;
import logicaDeNegocio.CuentaCorriente;
import persistenciaJPA.exceptions.NonexistentEntityException;
import persistenciaJPA.exceptions.PreexistingEntityException;

/**
 *
 * @author FamiliaGomez
 */
public class VentanaCuentaCorriente extends javax.swing.JInternalFrame {
    //CONTROLADORA DE LA INTERFAZ
    private ControladoraInterfaz miLogica;
    private DefaultTableModel modelo = new DefaultTableModel(){
        // sobreescribo el metodo para que no se modifiquen los campos de las filas en la tabla
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex){
            return false;
        }
    };
    private int banderaModificar;//bandera de modificacion
    private Cliente unCliente = null;
    
    /**
     * Creates new form VentanaCuentaCorriente
     */
    public VentanaCuentaCorriente(ControladoraInterfaz unaControladora) throws PreexistingEntityException{
        initComponents();
        this.miLogica = unaControladora;
        this.activarDatosCuentaCorriente(false);
        this.activarDatosCliente(false);
        /// Agregar las cabeceras de la tabla
        modelo.addColumn("Id Cuenta Corriente");
        modelo.addColumn("Saldo");
        modelo.addColumn("Id Cliente");
        modelo.addColumn("Nombre Cliente");
        modelo.addColumn("Apellido Cliente");
        this.jTableCuentaCorriente.setModel(modelo);
        // codigo para ordenas las filas
        this.jTableCuentaCorriente.setRowSorter(new TableRowSorter(modelo));
        banderaModificar = -1;
        // manejo de la ventana
        this.setClosable(true);
        this.setIconifiable(true);
        
        this.cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDatosCuentaCorriente = new javax.swing.JPanel();
        jLabelIdCuentaCorriente = new javax.swing.JLabel();
        jTextFieldIdCuentaCorriente = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelSaldo = new javax.swing.JLabel();
        jTextFieldSaldo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCuentaCorriente = new javax.swing.JTable();
        jButtonNuevo = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jPanelDatosCliente = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jLabelIdCliente = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldIdCliente = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();

        jPanelDatosCuentaCorriente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos Cuenta Corriente"));

        jLabelIdCuentaCorriente.setText("Id Cuenta Corriente:");

        jTextFieldIdCuentaCorriente.setEditable(false);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelSaldo.setText("Saldo:");

        javax.swing.GroupLayout jPanelDatosCuentaCorrienteLayout = new javax.swing.GroupLayout(jPanelDatosCuentaCorriente);
        jPanelDatosCuentaCorriente.setLayout(jPanelDatosCuentaCorrienteLayout);
        jPanelDatosCuentaCorrienteLayout.setHorizontalGroup(
            jPanelDatosCuentaCorrienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCuentaCorrienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosCuentaCorrienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosCuentaCorrienteLayout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanelDatosCuentaCorrienteLayout.createSequentialGroup()
                        .addGroup(jPanelDatosCuentaCorrienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelIdCuentaCorriente)
                            .addComponent(jLabelSaldo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosCuentaCorrienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jTextFieldIdCuentaCorriente))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDatosCuentaCorrienteLayout.setVerticalGroup(
            jPanelDatosCuentaCorrienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCuentaCorrienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosCuentaCorrienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdCuentaCorriente)
                    .addComponent(jTextFieldIdCuentaCorriente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosCuentaCorrienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSaldo)
                    .addComponent(jTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanelDatosCuentaCorrienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cuentas Corrientes"));

        jTableCuentaCorriente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCuentaCorriente);

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEliminar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevo)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonModificar))
                .addContainerGap())
        );

        jPanelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Cliente"));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabelIdCliente.setText("Id Cliente:");

        jLabelNombre.setText("Nombre:");

        jLabelApellido.setText("Apellido:");

        jTextFieldNombre.setEditable(false);

        jTextFieldApellido.setEditable(false);

        javax.swing.GroupLayout jPanelDatosClienteLayout = new javax.swing.GroupLayout(jPanelDatosCliente);
        jPanelDatosCliente.setLayout(jPanelDatosClienteLayout);
        jPanelDatosClienteLayout.setHorizontalGroup(
            jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelApellido)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelIdCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldApellido)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jTextFieldIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButtonBuscar)
                .addContainerGap())
        );
        jPanelDatosClienteLayout.setVerticalGroup(
            jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdCliente)
                    .addComponent(jButtonBuscar)
                    .addComponent(jTextFieldIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellido)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatosCuentaCorriente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDatosCuentaCorriente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        // TODO add your handling code here:
        this.activarDatosCliente(true);
        this.jButtonAceptar.setEnabled(false);
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.activarDatosCuentaCorriente(false);
        this.activarDatosCliente(false);
        this.limpiarDatos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        if(this.jTextFieldIdCliente.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO PARA REALIZAR LA BUSQUEDA", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO PARA REALIZAR LA BUSQUEDA", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            List<Cliente> clientes = null;
            int idCliente = Integer.parseInt(this.jTextFieldIdCliente.getText());// leo y guardo el id de un cliente
            try {
                clientes = this.miLogica.dameClientes();
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(VentanaTurno.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(Cliente e : clientes){// recorro la lista de clientes
                if(e.isId(idCliente)){// si corresponde al id lo almaceno en unCliente
                    this.unCliente = e;
                }
            }
            if(this.unCliente != null){// verifico si encontro al cliente
                if(!this.unCliente.tieneCuentaCorriente()){// verifico si tiene una cuenta corriente
                    this.jButtonAceptar.setEnabled(true);
                    this.jTextFieldNombre.setText(this.unCliente.getNombre());// muestro el nombre del cliente
                    this.jTextFieldApellido.setText(this.unCliente.getApellido());// muestro el apellido del cliente
                    this.activarDatosCuentaCorriente(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "EL CLIENTE "+this.unCliente.getNombre()+" "+this.unCliente.getApellido()+" POSEE UNA CUENTA CORRIENTE.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    this.jButtonAceptar.setEnabled(false);
                    this.jTextFieldIdCliente.setText("");
                    this.unCliente = null;
                }
            }
            else{// si no encuentro a un cliente con el idCliente
                JOptionPane.showMessageDialog(null, "NO EXISTE UN CLIENTE CON EL ID: "+idCliente, "ERROR", JOptionPane.ERROR_MESSAGE);
                this.jButtonAceptar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        if(this.banderaModificar == -1){
            this.crearCuentaCorriente();
        }
        else{
            this.modificarCuentaCorriente();
        }
        this.limpiarDatos();
        this.activarDatosCuentaCorriente(false);
        this.activarDatosCliente(false);
        try {
            actualizarFilas();
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        int seleccionCuentaCorriente = this.jTableCuentaCorriente.getSelectedRow();
        int i = 1;
        if(seleccionCuentaCorriente == -1){// si no se selecciono nada de la tabla
            JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONE UNA FILA", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            i = JOptionPane.showConfirmDialog(this, "Estas Seguro ?", "Vas a Modificar una Cuenta Corriente", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                int idCliente = Integer.parseInt(this.jTableCuentaCorriente.getValueAt(seleccionCuentaCorriente, 2).toString());
                try {
                    Cliente unCliente = this.miLogica.dameMiCliente(idCliente);
                    this.activarDatosCliente(true);
                    this.activarDatosCuentaCorriente(true);
                    this.jButtonBuscar.setEnabled(false);
                    this.jTextFieldIdCliente.setEnabled(false);
                    this.jTextFieldIdCliente.setText(String.valueOf(unCliente.getId()));
                    this.jTextFieldNombre.setText(unCliente.getNombre());
                    this.jTextFieldApellido.setText(unCliente.getApellido());
                    this.jTextFieldIdCuentaCorriente.setText(String.valueOf(unCliente.getUnaCuentaCorriente().getIdCuentaCorriente()));
                    this.jTextFieldSaldo.setText(String.valueOf(unCliente.getUnaCuentaCorriente().getSaldo()));
                    this.banderaModificar = unCliente.getUnaCuentaCorriente().getIdCuentaCorriente();
                    this.jButtonAceptar.setEnabled(true);
                    this.jButtonCancelar.setEnabled(true);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        int seleccionCuentaCorriente = this.jTableCuentaCorriente.getSelectedRow();
        int i = 1;
        if(seleccionCuentaCorriente == -1){// si no se selecciono nada de la tabla
            JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONE UNA FILA", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            i = JOptionPane.showConfirmDialog(this, "Estas Seguro ?", "Vas a Eliminar una Cuenta Corriente", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                    int idCuentaCorriente = Integer.parseInt(this.jTableCuentaCorriente.getValueAt(seleccionCuentaCorriente, 0).toString());
                    int idCliente = Integer.parseInt(this.jTableCuentaCorriente.getValueAt(seleccionCuentaCorriente, 2).toString());
                try {
                    this.miLogica.eliminarCuentaCorriente(idCuentaCorriente, idCliente);
                    DefaultTableModel dtm = (DefaultTableModel) jTableCuentaCorriente.getModel();
                    dtm.removeRow(jTableCuentaCorriente.getSelectedRow()); 
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelIdCliente;
    private javax.swing.JLabel jLabelIdCuentaCorriente;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDatosCliente;
    private javax.swing.JPanel jPanelDatosCuentaCorriente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCuentaCorriente;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldIdCliente;
    private javax.swing.JTextField jTextFieldIdCuentaCorriente;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldSaldo;
    // End of variables declaration//GEN-END:variables

    public void activarDatosCliente(boolean b){
        this.jPanelDatosCliente.setEnabled(b);
        this.jLabelIdCliente.setEnabled(b);
        this.jLabelNombre.setEnabled(b);
        this.jLabelApellido.setEnabled(b);
        this.jTextFieldIdCliente.setEnabled(b);
        this.jTextFieldNombre.setEnabled(b);
        this.jTextFieldApellido.setEnabled(b);
        this.jButtonBuscar.setEnabled(b);
        this.jButtonAceptar.setEnabled(b);
        this.jButtonCancelar.setEnabled(b);
    }

    public void activarDatosCuentaCorriente(boolean b){
        this.jPanelDatosCuentaCorriente.setEnabled(b);
        this.jLabelIdCuentaCorriente.setEnabled(b);
        this.jLabelSaldo.setEnabled(b);
        this.jTextFieldIdCuentaCorriente.setEnabled(b);
        this.jTextFieldSaldo.setEnabled(b);
    }
    
    public void cargarTabla() throws PreexistingEntityException{
        List<Cliente> clientes = this.miLogica.dameClientes();
        Object[]fila= new Object[5];
        for(Cliente e:clientes){
            if(e.tieneCuentaCorriente()){
                fila[0] = e.getUnaCuentaCorriente().getIdCuentaCorriente();
                fila[1] = e.getUnaCuentaCorriente().getSaldo();
                fila[2] = e.getId();
                fila[3] = e.getNombre();
                fila[4] = e.getApellido();
                this.modelo.addRow(fila);
            this.jTableCuentaCorriente.setModel(modelo);
            }
        }   
    }
    
    public void limpiarDatos(){
        this.jTextFieldIdCliente.setText("");
        this.jTextFieldNombre.setText("");
        this.jTextFieldApellido.setText("");
        this.jTextFieldIdCuentaCorriente.setText("");
        this.jTextFieldSaldo.setText("");
        this.unCliente = null;
    }
    
    public void actualizarFilas() throws PreexistingEntityException{
        DefaultTableModel modeloSucursales = (DefaultTableModel) jTableCuentaCorriente.getModel();
        int filas = jTableCuentaCorriente.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }
        cargarTabla();
    }
    
    public void crearCuentaCorriente(){
        try {
            int idCliente = Integer.parseInt(this.jTextFieldIdCliente.getText());
            double saldo = Double.parseDouble(this.jTextFieldSaldo.getText());
            this.miLogica.crearCuentaCorriente(idCliente, saldo);
        } catch (Exception ex) {
            Logger.getLogger(VentanaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarCuentaCorriente(){
        try {
            int idCliente = Integer.parseInt(this.jTextFieldIdCliente.getText());
            double saldo = Double.parseDouble(this.jTextFieldSaldo.getText());
            int idCuentaCorriente = Integer.parseInt(this.jTextFieldIdCuentaCorriente.getText());
            this.miLogica.modificarCuentaCorriente(idCuentaCorriente, idCliente, saldo);
            this.banderaModificar = -1;
        } catch (Exception ex) {
            Logger.getLogger(VentanaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}