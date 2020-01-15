/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;

/**
 *
 * @author Usuario
 */
public class Archivos {
    private File archivoMaestros;
    private File archivoAsignaturas;
    private File archivoAlumnos;  
    private File rutaDeGuardado;

    public File getArchivoMaestros() {
        return archivoMaestros;
    }

    public void setArchivoMaestros(File archivoMaestros) {
        this.archivoMaestros = archivoMaestros;
    }

    public File getArchivoAsignaturas() {
        return archivoAsignaturas;
    }

    public void setArchivoAsignaturas(File archivoAsignaturas) {
        this.archivoAsignaturas = archivoAsignaturas;
    }

    public File getArchivoAlumnos() {
        return archivoAlumnos;
    }

    public void setArchivoAlumnos(File archivoAlumnos) {
        this.archivoAlumnos = archivoAlumnos;
    }

    public File getRutaDeGuardado() {
        return rutaDeGuardado;
    }

    public void setRutaDeGuardado(File rutaDeGuardado) {
        this.rutaDeGuardado = rutaDeGuardado;
    }
    
}
