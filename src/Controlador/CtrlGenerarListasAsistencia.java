/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.ComboItem;
import Modelo.CursoImpartido;
import Modelo.GestorDeArchivos;
import Modelo.InformacionArchivos;
import Modelo.Maestro;
import Vista.FrmGenerarListasAsistencia;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Usuario
 */
public class CtrlGenerarListasAsistencia {
    private InformacionArchivos modeloArchivos;
    private FrmGenerarListasAsistencia FrmRelacion;
    private GestorDeArchivos gestor;
    private String nombreArchivoResultante = "RelacionAlumnoMaestroAsignatura.csv";  

    public CtrlGenerarListasAsistencia() {
        this.gestor = new GestorDeArchivos();
    }
    
    public void generarListaAsistencia(String idMaestro, String idAsignatura) {
        ArrayList<CursoImpartido> listaCursos = modeloArchivos.getListaCursosImpartidos();        
        CursoImpartido curso = new CursoImpartido();
        for(int i = 0; i < listaCursos.size(); i++) {
            if(listaCursos.get(i).getMaestro().getClave().equals(idMaestro) && listaCursos.get(i).getAsignatura().getClave().equals(idAsignatura)) {
                curso = listaCursos.get(i);
                System.out.println("Sin ordenar: ");
                System.out.println(curso.getListaAlumnos());
                System.out.println("Ordenado: ");
                System.out.println(ordenarAlumnosAlfabeticamente(curso.getListaAlumnos()));
            }
        }
    }
    
    public ArrayList<String> ordenarAlumnosAlfabeticamente(ArrayList<Alumno> listaAlumnos) {
        ArrayList<String> listaAlumnosOrdenada = new ArrayList<String>();
        for(int i = 0; i < listaAlumnos.size(); i++) {
            listaAlumnosOrdenada.add(listaAlumnos.get(i).getApellido() + " " + listaAlumnos.get(i).getNombre());
        }
        Collections.sort(listaAlumnosOrdenada);
        return listaAlumnosOrdenada;
    }
    
    public void rellenarMaestros() {
        FrmRelacion.getComboMaestros().removeAllItems();
        Maestro maestro;
        FrmRelacion.getComboMaestros().addItem(null);        
        for (int i = 0; i < modeloArchivos.getListaMaestros().size(); i++) {
            maestro = modeloArchivos.getListaMaestros().get(i);
            FrmRelacion.getComboMaestros().addItem(new ComboItem(maestro.getClave(), maestro.getNombre() + " " + maestro.getApellido()));
        }
    }

    public void rellenarAsignaturas(String idMaestro) {
        FrmRelacion.getComboAsignaturas().removeAllItems();
        ArrayList<Asignatura> asignaturasMaestro = getAsignaturasMaestro(idMaestro);
        if(asignaturasMaestro.size() > 0) {
            Asignatura asignatura;
            for (int i = 0; i < asignaturasMaestro.size(); i++) {
                asignatura = asignaturasMaestro.get(i);
                FrmRelacion.getComboAsignaturas().addItem(new ComboItem(asignatura.getClave(), asignatura.getNombre()));
            }
        }
    }
    
    public ArrayList<Asignatura> getAsignaturasMaestro(String idMaestro) {
        ArrayList<Asignatura> asignaturasMaestro = new ArrayList<Asignatura>();
        ArrayList<String> lineasArchivo = gestor.getLineasArchivo(modeloArchivos.getRutaDeGuardado().getAbsolutePath() + "/" + "RelacionMaestroAsignatura.csv");
        Asignatura asignatura = null;
        for (int i = 0; i < lineasArchivo.size(); i++) {
            String[] datos = lineasArchivo.get(i).split(",");
            if (datos[0].equals(idMaestro)) {
                asignatura = getAsignaturaPorId(datos[1]);
                if(asignatura != null) {
                    asignaturasMaestro.add(asignatura);
                }
            }
        }
        return asignaturasMaestro;
    }    
    
    public Asignatura getAsignaturaPorId(String id) {
        Asignatura asignatura = null;
        for(int i = 0; i < modeloArchivos.getListaAsignaturas().size(); i++) {
            if(modeloArchivos.getListaAsignaturas().get(i).getClave().equals(id)) {
                asignatura = modeloArchivos.getListaAsignaturas().get(i);
                break;
            }
        }
        return asignatura;
    }

    public InformacionArchivos getModeloArchivos() {
        return modeloArchivos;
    }

    public void setModeloArchivos(InformacionArchivos modeloArchivos) {
        this.modeloArchivos = modeloArchivos;
    }

    public FrmGenerarListasAsistencia getFrmRelacion() {
        return FrmRelacion;
    }

    public void setFrmRelacion(FrmGenerarListasAsistencia FrmRelacion) {
        this.FrmRelacion = FrmRelacion;
    }
        
}
