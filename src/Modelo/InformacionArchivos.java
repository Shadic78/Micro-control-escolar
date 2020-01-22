/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class InformacionArchivos {
    private ArrayList<Maestro> listaMaestros;
    private ArrayList<Asignatura> listaAsignaturas;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<CursoImpartido> listaCursosImpartidos;
    private File rutaDeGuardado;

    public ArrayList<Maestro> getListaMaestros() {
        return listaMaestros;
    }

    public void setListaMaestros(ArrayList<Maestro> listaMaestros) {
        this.listaMaestros = listaMaestros;
    }

    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public File getRutaDeGuardado() {
        return rutaDeGuardado;
    }

    public void setRutaDeGuardado(File rutaDeGuardado) {
        this.rutaDeGuardado = rutaDeGuardado;
    }

    public ArrayList<CursoImpartido> getListaCursosImpartidos() {
        return listaCursosImpartidos;
    }

    public void setListaCursosImpartidos(ArrayList<CursoImpartido> listaCursosImpartidos) {
        this.listaCursosImpartidos = listaCursosImpartidos;
    }
        
}
