/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.GestorDeArchivos;
import Modelo.Maestro;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CtrlCargarArchivos {
    private GestorDeArchivos gestor;
    private ArrayList<String> lineasArchivo;

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
    
}
