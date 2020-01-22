/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlInscribirAlumnoAsignatura;
import Controlador.CtrlRelacionMaestroAsignatura;
import Modelo.InformacionArchivos;

/**
 *
 * @author Usuario
 */
public class MenuPrincipal extends javax.swing.JFrame {
    InformacionArchivos modeloArchivos;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    public InformacionArchivos getModeloArchivos() {
        return modeloArchivos;
    }

    public void setModeloArchivos(InformacionArchivos modeloArchivos) {
        this.modeloArchivos = modeloArchivos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnMaestroAsignatura = new javax.swing.JButton();
        BtnInscribirAlumnos = new javax.swing.JButton();
        BtnListasAsistencia = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Microcontrol escolar");

        jLabel2.setText("Menu");

        BtnMaestroAsignatura.setText("Asignar maestros");
        BtnMaestroAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMaestroAsignaturaActionPerformed(evt);
            }
        });

        BtnInscribirAlumnos.setText("Inscribir alumnos");
        BtnInscribirAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInscribirAlumnosActionPerformed(evt);
            }
        });

        BtnListasAsistencia.setText("Listas de asistencia");

        jButton4.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnMaestroAsignatura)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(jLabel2)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnInscribirAlumnos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(BtnListasAsistencia)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnMaestroAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnInscribirAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnListasAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMaestroAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMaestroAsignaturaActionPerformed
        FrmRelacionMaestroAsignatura frmRelacionar = new FrmRelacionMaestroAsignatura();
        
        CtrlRelacionMaestroAsignatura ctrlFrmRelacionar = new CtrlRelacionMaestroAsignatura();
        ctrlFrmRelacionar.setModeloArchivos(modeloArchivos);
        ctrlFrmRelacionar.setFrmRelacion(frmRelacionar);
        
        frmRelacionar.setCtrlForm(ctrlFrmRelacionar);
        ctrlFrmRelacionar.rellenarMaestros();
        ctrlFrmRelacionar.rellenarAsignaturas();
        
        frmRelacionar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnMaestroAsignaturaActionPerformed

    private void BtnInscribirAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInscribirAlumnosActionPerformed
        FrmInscribirAlumnoAsignatura frmRelacionar = new FrmInscribirAlumnoAsignatura();
        
        CtrlInscribirAlumnoAsignatura ctrlFrmRelacionar = new CtrlInscribirAlumnoAsignatura();
        ctrlFrmRelacionar.setModeloArchivos(modeloArchivos);
        ctrlFrmRelacionar.setFrmRelacion(frmRelacionar);
        
        frmRelacionar.setCtrlForm(ctrlFrmRelacionar);
        ctrlFrmRelacionar.rellenarAlumnos();        
        ctrlFrmRelacionar.rellenarMaestros();
        ctrlFrmRelacionar.rellenarAsignaturas();
        
        frmRelacionar.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_BtnInscribirAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInscribirAlumnos;
    private javax.swing.JButton BtnListasAsistencia;
    private javax.swing.JButton BtnMaestroAsignatura;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
