/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CursoImpartido {
    private Maestro maestro;
    private Asignatura asignatura;
    private ArrayList<Alumno> listaAlumnos;

    public CursoImpartido() {
       this.listaAlumnos = new ArrayList<Alumno>();
    }
    
    public void inscribirAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
    }
    
    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public String toString() {
        return "CursoImpartido{" + "maestro=" + maestro + ", asignatura=" + asignatura + ", listaAlumnos=" + listaAlumnos + '}';
    }
    
}
