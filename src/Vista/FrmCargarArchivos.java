/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlCargarArchivos;
import Controlador.CtrlRelacionMaestroAsignatura;
import Modelo.GestorDeArchivos;
import Modelo.InformacionArchivos;
import java.io.File;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class FrmCargarArchivos extends javax.swing.JFrame {
    private GestorDeArchivos gestor;
    private CtrlCargarArchivos controlArchivos;
    private InformacionArchivos modeloArchivos;

    /**
     * Creates new form Inicio
     */
    public FrmCargarArchivos() {
        initComponents();
        this.controlArchivos = new CtrlCargarArchivos();
        this.modeloArchivos = new InformacionArchivos();
        this.gestor = new GestorDeArchivos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnCargarMaestros = new javax.swing.JButton();
        BtnCargarAsignaturas = new javax.swing.JButton();
        BtnCargarAlumnos = new javax.swing.JButton();
        BtnRutaGuardado = new javax.swing.JButton();
        TxtRutaMaestros = new javax.swing.JLabel();
        TxtRutaAsignaturas = new javax.swing.JLabel();
        TxtRutaAlumnos = new javax.swing.JLabel();
        TxtRutaGuardado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BtnContinuar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnCargarMaestros.setText("Cargar maestros");
        BtnCargarMaestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarMaestrosActionPerformed(evt);
            }
        });

        BtnCargarAsignaturas.setText("Cargar asignaturas");
        BtnCargarAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarAsignaturasActionPerformed(evt);
            }
        });

        BtnCargarAlumnos.setText("Cargar alumnos");
        BtnCargarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarAlumnosActionPerformed(evt);
            }
        });

        BtnRutaGuardado.setText("Ruta de guardado");
        BtnRutaGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRutaGuardadoActionPerformed(evt);
            }
        });

        TxtRutaMaestros.setText("...");

        TxtRutaAsignaturas.setText("...");

        TxtRutaAlumnos.setText("...");

        TxtRutaGuardado.setText("...");

        BtnContinuar.setText("Continuar");
        BtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnContinuarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cargar archivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnCargarAsignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnCargarAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnCargarMaestros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnRutaGuardado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtRutaMaestros)
                            .addComponent(TxtRutaAsignaturas)
                            .addComponent(TxtRutaAlumnos)
                            .addComponent(TxtRutaGuardado))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnContinuar)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCargarMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtRutaMaestros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCargarAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtRutaAsignaturas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCargarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtRutaAlumnos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRutaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtRutaGuardado))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCargarMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarMaestrosActionPerformed
        File archivoSeleccionado = gestor.cargarArchivo();
        modeloArchivos.setListaMaestros(controlArchivos.obtenerMaestros(archivoSeleccionado.getAbsolutePath()));
        getTxtRutaMaestros().setText(archivoSeleccionado.getAbsolutePath());
    }//GEN-LAST:event_BtnCargarMaestrosActionPerformed

    private void BtnCargarAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarAsignaturasActionPerformed
        File archivoSeleccionado = gestor.cargarArchivo();
        modeloArchivos.setListaAsignaturas(controlArchivos.obtenerAsignaturas(archivoSeleccionado.getAbsolutePath()));
        getTxtRutaAsignaturas().setText(archivoSeleccionado.getAbsolutePath());
    }//GEN-LAST:event_BtnCargarAsignaturasActionPerformed

    private void BtnCargarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarAlumnosActionPerformed
        File archivoSeleccionado = gestor.cargarArchivo();
        modeloArchivos.setListaAlumnos(controlArchivos.obtenerAlumnos(archivoSeleccionado.getAbsolutePath()));
        getTxtRutaAlumnos().setText(archivoSeleccionado.getAbsolutePath());  
    }//GEN-LAST:event_BtnCargarAlumnosActionPerformed

    private void BtnRutaGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRutaGuardadoActionPerformed
        File archivoSeleccionado = gestor.seleccionarDirectorio();
        modeloArchivos.setRutaDeGuardado(archivoSeleccionado);
        getTxtRutaGuardado().setText(archivoSeleccionado.getAbsolutePath());
    }//GEN-LAST:event_BtnRutaGuardadoActionPerformed

    private void BtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnContinuarActionPerformed
        FrmRelacionMaestroAsignatura frmRelacionar = new FrmRelacionMaestroAsignatura();
        
        CtrlRelacionMaestroAsignatura ctrlFrmRelacionar = new CtrlRelacionMaestroAsignatura();
        ctrlFrmRelacionar.setModeloArchivos(modeloArchivos);
        ctrlFrmRelacionar.setFrmRelacion(frmRelacionar);
        
        frmRelacionar.setCtrlForm(ctrlFrmRelacionar);
        ctrlFrmRelacionar.rellenarMaestros();
        ctrlFrmRelacionar.rellenarAsignaturas();
        
        frmRelacionar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnContinuarActionPerformed

    public JLabel getTxtRutaAlumnos() {
        return TxtRutaAlumnos;
    }

    public void setTxtRutaAlumnos(JLabel TxtRutaAlumnos) {
        this.TxtRutaAlumnos = TxtRutaAlumnos;
    }

    public JLabel getTxtRutaAsignaturas() {
        return TxtRutaAsignaturas;
    }

    public void setTxtRutaAsignaturas(JLabel TxtRutaAsignaturas) {
        this.TxtRutaAsignaturas = TxtRutaAsignaturas;
    }

    public JLabel getTxtRutaGuardado() {
        return TxtRutaGuardado;
    }

    public void setTxtRutaGuardado(JLabel TxtRutaGuardado) {
        this.TxtRutaGuardado = TxtRutaGuardado;
    }

    public JLabel getTxtRutaMaestros() {
        return TxtRutaMaestros;
    }

    public void setTxtRutaMaestros(JLabel TxtRutaMaestros) {
        this.TxtRutaMaestros = TxtRutaMaestros;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCargarAlumnos;
    private javax.swing.JButton BtnCargarAsignaturas;
    private javax.swing.JButton BtnCargarMaestros;
    private javax.swing.JButton BtnContinuar;
    private javax.swing.JButton BtnRutaGuardado;
    private javax.swing.JLabel TxtRutaAlumnos;
    private javax.swing.JLabel TxtRutaAsignaturas;
    private javax.swing.JLabel TxtRutaGuardado;
    private javax.swing.JLabel TxtRutaMaestros;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
