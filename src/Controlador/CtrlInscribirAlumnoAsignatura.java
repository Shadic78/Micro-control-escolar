/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.ComboItem;
import Modelo.GestorDeArchivos;
import Modelo.InformacionArchivos;
import Modelo.Maestro;
import Vista.FrmInscribirAlumnoAsignatura;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Usuario
 */
public class CtrlInscribirAlumnoAsignatura {
    private FrmInscribirAlumnoAsignatura FrmRelacion;
    private InformacionArchivos modeloArchivos;
    private GestorDeArchivos gestor;
    private String nombreArchivoResultante = "RelacionAlumnoMaestroAsignatura.csv";

    public CtrlInscribirAlumnoAsignatura() {
        this.gestor = new GestorDeArchivos();
    }
    
    public void rellenarAlumnos() {
        FrmRelacion.getComboAlumnos().removeAllItems();
        Alumno alumno;
        for (int i = 0; i < modeloArchivos.getListaMaestros().size(); i++) {
            alumno = modeloArchivos.getListaAlumnos().get(i);
            FrmRelacion.getComboAlumnos().addItem(new ComboItem(alumno.getMatricula(), alumno.getNombre() + " " + alumno.getApellido()));
        }
    }    

    public void rellenarMaestros() {
        FrmRelacion.getComboMaestros().removeAllItems();
        Maestro maestro;
        for (int i = 0; i < modeloArchivos.getListaMaestros().size(); i++) {
            maestro = modeloArchivos.getListaMaestros().get(i);
            FrmRelacion.getComboMaestros().addItem(new ComboItem(maestro.getClave(), maestro.getNombre() + " " + maestro.getApellido()));
        }
    }

    public void rellenarAsignaturas() {
        FrmRelacion.getComboAsignaturas().removeAllItems();
        Asignatura asignatura;
        for (int i = 0; i < modeloArchivos.getListaAsignaturas().size(); i++) {
            asignatura = modeloArchivos.getListaAsignaturas().get(i);
            FrmRelacion.getComboAsignaturas().addItem(new ComboItem(asignatura.getClave(), asignatura.getNombre()));
        }
    }

    public void crearRelacion(String idAlumno, String idMaestro, String idAsignatura) throws IOException {
        if (!isRepeated(idAlumno, idMaestro, idAsignatura)) {
            gestor.addTextoArchivo(idAlumno + "," + idMaestro + "," + idAsignatura, modeloArchivos.getRutaDeGuardado().getAbsolutePath() + "/" + nombreArchivoResultante);
            JOptionPane.showMessageDialog(null, "Alumno inscrito exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "El alumno ya esta inscrito a esa materia", "Error", ERROR_MESSAGE);
        }
    }

    public boolean isRepeated(String idAlumno, String idMaestro, String idAsignatura) {
        boolean repetido = false;
        ArrayList<String> lineasArchivo = gestor.getLineasArchivo(modeloArchivos.getRutaDeGuardado().getAbsolutePath() + "/" + nombreArchivoResultante);
        for (int i = 0; i < lineasArchivo.size(); i++) {
            String[] datos = lineasArchivo.get(i).split(",");
            if (datos[0].equals(idAlumno) && datos[1].equals(idMaestro) && datos[2].equals(idAsignatura)) {
                repetido = true;
                break;
            }
        }
        return repetido;
    }

    public FrmInscribirAlumnoAsignatura getFrmRelacion() {
        return FrmRelacion;
    }

    public void setFrmRelacion(FrmInscribirAlumnoAsignatura FrmRelacion) {
        this.FrmRelacion = FrmRelacion;
    }

    public InformacionArchivos getModeloArchivos() {
        return modeloArchivos;
    }

    public void setModeloArchivos(InformacionArchivos modeloArchivos) {
        this.modeloArchivos = modeloArchivos;
    }

    public GestorDeArchivos getGestor() {
        return gestor;
    }

    public void setGestor(GestorDeArchivos gestor) {
        this.gestor = gestor;
    }

}
