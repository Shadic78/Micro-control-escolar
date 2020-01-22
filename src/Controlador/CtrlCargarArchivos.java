/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.CursoImpartido;
import Modelo.GestorDeArchivos;
import Modelo.InformacionArchivos;
import Modelo.Maestro;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CtrlCargarArchivos {
    private GestorDeArchivos gestor;
    private ArrayList<String> lineasArchivo;
    private InformacionArchivos modeloArchivos;

    public CtrlCargarArchivos() {
        this.gestor = new GestorDeArchivos();
    }

    public ArrayList<Maestro> obtenerMaestros(String ruta) {
        ArrayList<Maestro> maestros = new ArrayList<Maestro>();
        lineasArchivo = gestor.getLineasArchivo(ruta);
        for(int i = 0; i < lineasArchivo.size(); i++) {
            String[] datos = lineasArchivo.get(i).split(",");
            maestros.add(new Maestro(datos[0], datos[1], datos[2]));
        }
        return maestros;
    }
    
    public ArrayList<Asignatura> obtenerAsignaturas(String ruta) {
        ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
        lineasArchivo = gestor.getLineasArchivo(ruta);
        for(int i = 0; i < lineasArchivo.size(); i++) {
            String[] datos = lineasArchivo.get(i).split(",");
            asignaturas.add(new Asignatura(datos[0], datos[1], datos[2]));
        }
        return asignaturas;       
    } 
    
    public ArrayList<Alumno> obtenerAlumnos(String ruta) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        lineasArchivo = gestor.getLineasArchivo(ruta);
        for(int i = 0; i < lineasArchivo.size(); i++) {
            String[] datos = lineasArchivo.get(i).split(",");
            alumnos.add(new Alumno(datos[0], datos[1], datos[2]));
        }
        return alumnos;        
    }    
    
    /*
        Para usar este metodo primero debes asignar un objeto InformacionArchivos con su setter
        el parametro es la ruta del archivo de relacion maestro-asignatura
    */
    public ArrayList<CursoImpartido> obtenerCursosImpartidos(String ruta) {
        lineasArchivo = gestor.getLineasArchivo(ruta);        
        System.out.println(lineasArchivo.size());
        ArrayList<CursoImpartido> cursos = new ArrayList<CursoImpartido>();
        ArrayList<String> lineasArchivoInscripciones = gestor.getLineasArchivo(modeloArchivos.getRutaDeGuardado().getAbsolutePath() + "/" + "RelacionAlumnoMaestroAsignatura.csv");                    
        
        for(int i = 0; i < lineasArchivo.size(); i++) {
            String[] datos = lineasArchivo.get(i).split(",");
            CursoImpartido cursoNuevo = new CursoImpartido();
            Maestro maestro = getMaestroPorId(datos[0]);
            Asignatura asignatura = getAsignaturaPorId(datos[1]);
            cursoNuevo.setMaestro(maestro);
            cursoNuevo.setAsignatura(asignatura);;
            for(int j = 0; j < lineasArchivoInscripciones.size(); j++) {
                String[] datosInscripciones = lineasArchivoInscripciones.get(j).split(",");
                if(datosInscripciones[1].equals(maestro.getClave()) && datosInscripciones[2].equals(asignatura.getClave())) {
                    Alumno alumoNuevo = getAlumnoPorId(datosInscripciones[0]);
                    cursoNuevo.inscribirAlumno(alumoNuevo);
                }
            }
            cursos.add(cursoNuevo);
            System.out.println(cursoNuevo);
        }
        
        return cursos;
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
    
    public Maestro getMaestroPorId(String id) {
        Maestro maestro = null;
        for(int i = 0; i < modeloArchivos.getListaMaestros().size(); i++) {
            if(modeloArchivos.getListaMaestros().get(i).getClave().equals(id)) {
                maestro = modeloArchivos.getListaMaestros().get(i);
                break;
            }
        }
        return maestro;
    }       
    
    public Alumno getAlumnoPorId(String id) {
        Alumno alumno = null;
        for(int i = 0; i < modeloArchivos.getListaAlumnos().size(); i++) {
            if(modeloArchivos.getListaAlumnos().get(i).getMatricula().equals(id)) {
                alumno = modeloArchivos.getListaAlumnos().get(i);
                break;
            }
        }
        return alumno;
    }      

    public InformacionArchivos getModeloArchivos() {
        return modeloArchivos;
    }

    public void setModeloArchivos(InformacionArchivos modeloArchivos) {
        this.modeloArchivos = modeloArchivos;
    }
    
}
