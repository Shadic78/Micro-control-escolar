/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlGenerarListasAsistencia;
import Controlador.CtrlInscribirAlumnoAsignatura;
import Modelo.ComboItem;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FrmGenerarListasAsistencia extends javax.swing.JFrame {
    CtrlGenerarListasAsistencia ctrlForm;
    
    public FrmGenerarListasAsistencia() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboMaestros = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        BtnRelacionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboAsignaturas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComboMaestros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMaestrosItemStateChanged(evt);
            }
        });
        ComboMaestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMaestrosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Selecciona un maestro:");

        BtnRelacionar.setText("Generar lista");
        BtnRelacionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRelacionarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Generar listas de asistencia");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Selecciona una asignatura:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(ComboMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(ComboAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(BtnRelacionar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(ComboAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ComboMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(BtnRelacionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRelacionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRelacionarActionPerformed
        ComboItem maestroSeleccionado = ((ComboItem) getComboMaestros().getSelectedItem());
        ComboItem asignaturaSeleccionada = ((ComboItem) getComboAsignaturas().getSelectedItem()); 
        ctrlForm.generarListaAsistencia(maestroSeleccionado.getId(), asignaturaSeleccionada.getId());
    }//GEN-LAST:event_BtnRelacionarActionPerformed

    private void ComboMaestrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMaestrosItemStateChanged
    }//GEN-LAST:event_ComboMaestrosItemStateChanged

    private void ComboMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMaestrosActionPerformed
            ComboItem maestroSeleccionado = ((ComboItem) getComboMaestros().getSelectedItem());
            if(maestroSeleccionado != null) {
                ctrlForm.rellenarAsignaturas(maestroSeleccionado.getId());                
            }
            else {
                getComboAsignaturas().removeAllItems();
            }
    }//GEN-LAST:event_ComboMaestrosActionPerformed

    public JComboBox<ComboItem> getComboAsignaturas() {
        return ComboAsignaturas;
    }

    public void setComboAsignaturas(JComboBox<ComboItem> ComboAsignaturas) {
        this.ComboAsignaturas = ComboAsignaturas;
    }

    public JComboBox<ComboItem> getComboMaestros() {
        return ComboMaestros;
    }

    public void setComboMaestros(JComboBox<ComboItem> ComboMaestros) {
        this.ComboMaestros = ComboMaestros;
    }

    public CtrlGenerarListasAsistencia getCtrlForm() {
        return ctrlForm;
    }

    public void setCtrlForm(CtrlGenerarListasAsistencia ctrlForm) {
        this.ctrlForm = ctrlForm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRelacionar;
    private javax.swing.JComboBox<ComboItem> ComboAsignaturas;
    private javax.swing.JComboBox<ComboItem> ComboMaestros;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}