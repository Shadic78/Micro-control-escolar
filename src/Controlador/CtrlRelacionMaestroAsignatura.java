/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivos;
import Modelo.Asignatura;
import Modelo.ComboItem;
import Modelo.GestorDeArchivos;
import Modelo.InformacionArchivos;
import Modelo.Maestro;
import Vista.FrmRelacionMaestroAsignatura;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

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
    
    public void crearRelacion(String idMaestro, String idAsignatura) throws IOException {
        if(!isRepeated(idMaestro, idAsignatura)) {
            gestor.addTextoArchivo(idMaestro + "," + idAsignatura, modeloArchivos.getRutaDeGuardado().getAbsolutePath() + "/" + "RelacionMaestroAsignatura.csv");
            JOptionPane.showMessageDialog(null, "Relacion creada");            
        }
        else {
            JOptionPane.showMessageDialog(null, "La relacion ya existe", "Error", ERROR_MESSAGE);
        }
    }
    
    public boolean isRepeated(String idMaestro, String idAsignatura) {
        boolean repetido = false;
        ArrayList<String> lineasArchivo = gestor.getLineasArchivo(modeloArchivos.getRutaDeGuardado().getAbsolutePath() + "/" + "RelacionMaestroAsignatura.csv");
        for(int i = 0; i < lineasArchivo.size(); i++) {
            String[] datos = lineasArchivo.get(i).split(",");
            if(datos[0].equals(idMaestro) && datos[1].equals(idAsignatura)) {
                repetido = true;
                //System.out.println("Repetidos: " + datos[0] + " - " + datos[1]);
                break;
            }
        }
        return repetido;
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
