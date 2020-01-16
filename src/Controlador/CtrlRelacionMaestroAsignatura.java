/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Asignatura;
import Modelo.ComboItem;
import Modelo.GestorDeArchivos;
import Modelo.InformacionArchivos;
import Modelo.Maestro;
import Vista.FrmRelacionMaestroAsignatura;

/**
 *
 * @author Usuario
 */
public class CtrlRelacionMaestroAsignatura {
    private FrmRelacionMaestroAsignatura FrmRelacion;
    private InformacionArchivos modeloArchivos;
    private GestorDeArchivos gestor;

    public CtrlRelacionMaestroAsignatura() {
        this.gestor = new GestorDeArchivos();
    }  
    
    public void rellenarMaestros() {
        FrmRelacion.getComboMaestros().removeAllItems();
        Maestro maestro;        
        for(int i = 0; i < modeloArchivos.getListaMaestros().size(); i++) {
            maestro = modeloArchivos.getListaMaestros().get(i);
            FrmRelacion.getComboMaestros().addItem(new ComboItem(maestro.getClave(), maestro.getNombre() + " " + maestro.getApellido()));
        }
    }
    
    public void rellenarAsignaturas() {
        FrmRelacion.getComboAsignaturas().removeAllItems();
        Asignatura asignatura;
        for(int i = 0; i < modeloArchivos.getListaAsignaturas().size(); i++) {
            asignatura = modeloArchivos.getListaAsignaturas().get(i);
            FrmRelacion.getComboAsignaturas().addItem(new ComboItem(asignatura.getClave(), asignatura.getNombre()));
        }  
    }
    
    public void crearRelacion(String idMaestro, String idAsignatura) {
        System.out.println("maestro: " + idMaestro + ", asignatura: " + idAsignatura);    
    }
    
    
    public FrmRelacionMaestroAsignatura getFrmRelacion() {
        return FrmRelacion;
    }

    public void setFrmRelacion(FrmRelacionMaestroAsignatura FrmRelacion) {
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
