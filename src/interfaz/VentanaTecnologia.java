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
import logicaDeNegocio.Tecnologia;
import persistenciaJPA.exceptions.NonexistentEntityException;
import persistenciaJPA.exceptions.PreexistingEntityException;

/**
 *
 * @author FamiliaGomez
 */
public class VentanaTecnologia extends javax.swing.JInternalFrame {
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
    /**
     * Creates new form VentanaTecnologia
     */
    public VentanaTecnologia(ControladoraInterfaz unaControladora) throws PreexistingEntityException {
        initComponents();
        
        this.miLogica = unaControladora;
        this.activarDatosTecnologia(false);
        /// Agregar las cabeceras de la tabla
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        this.jTableTecnologias.setModel(modelo);
        // codigo para ordenas las filas
        this.jTableTecnologias.setRowSorter(new TableRowSorter(modelo));
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

        jPanel1 = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabelId = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTecnologias = new javax.swing.JTable();
        jButtonNuevo = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de Tecnologia"));

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

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescripcion);

        jLabelId.setText("Id:");

        jLabelNombre.setText("Nombre:");

        jLabelDescripcion.setText("Descripcion:");

        jTextFieldId.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDescripcion)
                            .addComponent(jLabelId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescripcion)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tecnologias"));

        jTableTecnologias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableTecnologias);

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevo)
                    .addComponent(jButtonModificar)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        // TODO add your handling code here:
        this.activarDatosTecnologia(true);
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.limpiarDatos();
        this.activarDatosTecnologia(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        if(this.banderaModificar == -1){
            this.crearTecnologia();
        }
        else{
            this.modificarTecnologia();
        }
        this.limpiarDatos();
        this.activarDatosTecnologia(false);
        try {
            this.actualizarFilas();
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int seleccionTecnologia = this.jTableTecnologias.getSelectedRow();
        int i = 1;
        if(seleccionTecnologia == -1){// si no se selecciono nada de la tabla
            JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONE UNA FILA", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            i = JOptionPane.showConfirmDialog(this, "Estas Seguro ?", "Vas a Eliminar una Tecnologia", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                    int id = Integer.parseInt(this.jTableTecnologias.getValueAt(seleccionTecnologia, 0).toString());
                try {
                    this.miLogica.eliminarTecnologia(id);
                    DefaultTableModel dtm = (DefaultTableModel) jTableTecnologias.getModel();
                    dtm.removeRow(jTableTecnologias.getSelectedRow()); 
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        int seleccionTecnologia = this.jTableTecnologias.getSelectedRow();
        int i = 1;
        if(seleccionTecnologia == -1){// si no se selecciono nada de la tabla
            JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONE UNA FILA", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            i = JOptionPane.showConfirmDialog(this, "Estas Seguro ?", "Vas a Modificar una Tecnologia", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                int id = Integer.parseInt(this.jTableTecnologias.getValueAt(seleccionTecnologia, 0).toString());
                try {
                    Tecnologia unaTecnologia = miLogica.dameMiTecnologia(id);
                    this.activarDatosTecnologia(true);
                    this.jTextFieldId.setText(String.valueOf(unaTecnologia.getId()));
                    this.jTextFieldNombre.setText(String.valueOf(unaTecnologia.getNombreTecnologia()));
                    this.jTextAreaDescripcion.setText(unaTecnologia.getDescripcionTecnologia());
                    this.banderaModificar = unaTecnologia.getId();
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(VentanaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTecnologias;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
    
    public void activarDatosTecnologia(boolean b){
        // label
        this.jLabelId.setEnabled(b);
        this.jLabelNombre.setEnabled(b);
        this.jLabelDescripcion.setEnabled(b);
        // text field
        this.jTextFieldId.setEnabled(b);
        this.jTextFieldNombre.setEnabled(b);
        this.jTextAreaDescripcion.setEnabled(b);
        // botones
        this.jButtonAceptar.setEnabled(b);
        this.jButtonCancelar.setEnabled(b);
    }
    
    public void cargarTabla() throws PreexistingEntityException{
        List<Tecnologia> tecnologias = this.miLogica.dameTecnologias();
        Object[]fila= new Object[3];
        for(Tecnologia e:tecnologias){
            fila[0] = e.getId();
            fila[1] = e.getNombreTecnologia();
            fila[2] = e.getDescripcionTecnologia();
            this.modelo.addRow(fila);
            this.jTableTecnologias.setModel(modelo);
        }   
    }

    public void actualizarFilas() throws PreexistingEntityException{
        DefaultTableModel modeloTecnologia = (DefaultTableModel) jTableTecnologias.getModel();
        int filas = jTableTecnologias.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }
        cargarTabla();
    }
    
    public void limpiarDatos(){
        // text field
        this.jTextFieldId.setText("");
        this.jTextFieldNombre.setText("");
        this.jTextAreaDescripcion.setText("");
    }
    
    public void crearTecnologia(){
        try {
            String nombre = this.jTextFieldNombre.getText();
            String descripcion = this.jTextAreaDescripcion.getText();
            this.miLogica.crearTecnologia(nombre, descripcion);
        } catch (Exception ex) {
            Logger.getLogger(VentanaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarTecnologia(){
        try {
            int idTecnologia = Integer.parseInt(this.jTextFieldId.getText());
            String nombre = this.jTextFieldNombre.getText();
            String descipcion = this.jTextAreaDescripcion.getText();
            this.miLogica.modificarTecnologia(idTecnologia, nombre, descipcion);
            this.banderaModificar = -1;
        } catch (Exception ex) {
            Logger.getLogger(VentanaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
