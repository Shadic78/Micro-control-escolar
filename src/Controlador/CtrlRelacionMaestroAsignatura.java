/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.GestorDeArchivos;
import Modelo.InformacionArchivos;
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
        for(int i = 0; i < modeloArchivos.getListaMaestros().size(); i++) {
            FrmRelacion.getComboMaestros().addItem(modeloArchivos.getListaMaestros().get(i).getNombre());            
        }
    }
    
    public void rellenarAsignaturas() {
        
    }
    
    public void crearRelacion(String idMaestro, String idAsignatura) {
        
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
