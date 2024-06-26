/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.agenciatributariapresentacion;

import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributarianegocio.DTO.TramiteDTO;
import com.mycompany.agenciatributarianegocio.control.Icontrol;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TeLesheo
 */
public class Consultar extends javax.swing.JFrame {
    Icontrol control;
    PersonaDTO persona=null;
    /**
     * Creates new form Consultar
     */
    public Consultar(Icontrol control) {
        this.control=control;
        initComponents();
        centrarFormulario(this);
        ocultarBotonesExtra();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        radio1 = new javax.swing.JRadioButton();
        radio2 = new javax.swing.JRadioButton();
        radio3 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        labelReferencia = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Seleccione el filtro para buscar");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio1);
        radio1.setText("CURP");
        radio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio2);
        radio2.setText("Nombre");
        radio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio3);
        radio3.setText("Año");
        radio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio3ActionPerformed(evt);
            }
        });

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtable);

        labelReferencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelReferencia.setText("Selecciona una persona y acepta para continuar");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radio1)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radio2)
                                .addGap(101, 101, 101)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radio3)
                                .addGap(144, 144, 144)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelReferencia))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(58, 58, 58)
                .addComponent(btnCancelar)
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(radio1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(radio2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radio3)
                                    .addComponent(btnRegresar)
                                    .addComponent(btnBuscar)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(labelReferencia)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnCancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Consulta de tramites");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
       
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        PaginaInicio frmIncio=new PaginaInicio(control);
        frmIncio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void radio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio1ActionPerformed
        limpiarTabla();
        desactivarDecoradorAutocompletado();
        txtBusqueda.setText("");
        cargarTipo(1);  
        activarDecoradorAutocompletado(); 
        ocultarBotonesExtra();
    }//GEN-LAST:event_radio1ActionPerformed

    private void radio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio2ActionPerformed
        limpiarTabla();
        desactivarDecoradorAutocompletado();
        txtBusqueda.setText("");
        cargarTipo(2);  
        activarDecoradorAutocompletado();
        ocultarBotonesExtra();
    }//GEN-LAST:event_radio2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         if (radio1.isSelected()) {
            String textoSeleccionado = txtBusqueda.getText();
            llenarTablaTramites(control.consultarTramites(textoSeleccionado, 1,persona));
        }else if (radio2.isSelected()) {
            String textoSeleccionado = txtBusqueda.getText();
            llenarTablaPersonas(control.consultaEspecificaPersonas(textoSeleccionado, 2));
            btnAceptar.setVisible(true);
            btnCancelar.setVisible(true);
            labelReferencia.setVisible(true);
        }   else if (radio3.isSelected()) {
            String textoSeleccionado = txtBusqueda.getText();
            llenarTablaPersonas(control.consultaEspecificaPersonas(textoSeleccionado, 3));
            btnAceptar.setVisible(true);
            btnCancelar.setVisible(true);
            labelReferencia.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void radio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio3ActionPerformed
        limpiarTabla();
        desactivarDecoradorAutocompletado();
        txtBusqueda.setText("");
        cargarTipo(3);  
        activarDecoradorAutocompletado();
        ocultarBotonesExtra();
    }//GEN-LAST:event_radio3ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int filaSeleccionada = jtable.getSelectedRow();

        // Verificar si se seleccionó alguna fila
        if (filaSeleccionada != -1) {
            obtenerPersonaTabla(filaSeleccionada);
            limpiarTabla();
            llenarTablaTramites(control.consultarTramites("", 2, persona));
        }else{
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTabla();
        ocultarBotonesExtra();
        txtBusqueda.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    
    private void desactivarDecoradorAutocompletado() {
        txtBusqueda.setDocument(new javax.swing.text.PlainDocument());
    }
    
    private void activarDecoradorAutocompletado() {
        cargarTipo(buttonGroup1.getSelection().getMnemonic());
    }
    
    private void cargarTipo(int tipo){
        
        if (tipo==1) {
            JList listaSugerencia= new JList(control.obtenerPersonas(1));
            AutoCompleteDecorator.decorate(listaSugerencia, txtBusqueda, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        }else if (tipo==2) {
            JList listaSugerencia= new JList(control.obtenerPersonas(2));
            AutoCompleteDecorator.decorate(listaSugerencia, txtBusqueda, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        }else if (tipo==3) {
            JList listaSugerencia= new JList(control.obtenerPersonas(3));
            AutoCompleteDecorator.decorate(listaSugerencia, txtBusqueda, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        }
        
    }
    
        private void llenarTablaTramites(List<TramiteDTO> tramitesDTOList){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Definir las columnas de la tabla
        String[] columnas = {"ID","Tipo" ,"Fecha Emisión", "Costo"};

        // Crear un DefaultTableModel con las columnas
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        // Recorrer la lista de TramiteDTO y agregar cada objeto como una fila en el modelo de la tabla
        for (TramiteDTO tramiteDTO : tramitesDTOList) {
            Object[] fila = {
                tramiteDTO.getId(),
                tramiteDTO.getTipo(),
                dateFormat.format(tramiteDTO.getFechaEmision().getTime()),
                tramiteDTO.getCosto()
            };
            model.addRow(fila);
            
        }

        // Establecer el modelo de la tabla
        jtable.setModel(model);
    }
    
    private void llenarTablaPersonas(List<PersonaDTO> personasDTOList){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String [] columnas = {"ID","Nombre","Apellido Paterno","Apellido Materno","CURP","RFC","FechaNac","Telefono"};
        
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        
        for (PersonaDTO personaDTO:personasDTOList) {
            Object[] fila = {
                personaDTO.getId(),
                personaDTO.getNombres(),
                personaDTO.getApellidoPaterno(),
                personaDTO.getApellidoMaterno(),
                personaDTO.getCurp(),
                personaDTO.getRfc(),
                dateFormat.format(personaDTO.getFechaNacimiento().getTime()),
                personaDTO.getTelefono()
            };
            model.addRow(fila);
        }
        
        jtable.setModel(model);
    }
   
    private void limpiarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        jtable.setModel(model);
    }

    private void ocultarBotonesExtra(){
        btnAceptar.setVisible(false);
        btnCancelar.setVisible(false);
        labelReferencia.setVisible(false);
    }

    private void obtenerPersonaTabla(int filaSeleccionada){
        
            // Obtener los datos de la fila seleccionada
            Long id = Long.parseLong(jtable.getValueAt(filaSeleccionada, 0).toString());
            String nombres = jtable.getValueAt(filaSeleccionada, 1).toString();
            String apellidoPaterno = jtable.getValueAt(filaSeleccionada, 2).toString();
            String apellidoMaterno = jtable.getValueAt(filaSeleccionada, 3).toString();
            String curp = jtable.getValueAt(filaSeleccionada, 4).toString();
            String rfc = jtable.getValueAt(filaSeleccionada, 5).toString();
            String fechaNacimientoStr = jtable.getValueAt(filaSeleccionada, 6).toString();

            // Crear un objeto Calendar
            Calendar fechaNacimiento = Calendar.getInstance();

            try {
                // Parsear la cadena de fecha y establecerla en el objeto Calendar
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaNacimientoStr);
                fechaNacimiento.setTime(fecha);
            } catch (ParseException e) {
                e.printStackTrace(); // Manejo adecuado del error
            }
            String telefono = jtable.getValueAt(filaSeleccionada, 7).toString();

            
            persona=new PersonaDTO();
            persona.setId(id);
            persona.setNombres(nombres);
            persona.setApellidoPaterno(apellidoPaterno);
            persona.setApellidoMaterno(apellidoMaterno);
            persona.setCurp(curp);
            persona.setRfc(rfc);
            persona.setFechaNacimiento(fechaNacimiento);
            persona.setTelefono(telefono);
            
    }
    
    
    public static void centrarFormulario(JFrame frame) {
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Obtener el tamaño del formulario
        Dimension frameSize = frame.getSize();
        // Calcular la posición x para centrar el formulario
        int x = (screenSize.width - frameSize.width) / 2;
        // Calcular la posición y para centrar el formulario
        int y = (screenSize.height - frameSize.height) / 2;
        // Establecer la posición del formulario
        frame.setLocation(x, y);
    }
    
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Consultar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable;
    private javax.swing.JLabel labelReferencia;
    private javax.swing.JRadioButton radio1;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JRadioButton radio3;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
