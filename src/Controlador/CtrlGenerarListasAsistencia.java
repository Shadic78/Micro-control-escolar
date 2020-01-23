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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                break;
            }
        }
        crearPDF(curso, ordenarAlumnosAlfabeticamente(curso.getListaAlumnos()));
    }

    public void crearPDF(CursoImpartido curso, ArrayList<String> listaAlumnos) {
        try {
            // Se crea el documento
            Document documento = new Document();
            // El OutPutStream para el fichero donde crearemos el PDF
            FileOutputStream ficheroPDF;
            String nombreArchivoResultante = curso.getAsignatura().getNombre() + curso.getMaestro().getApellido() + curso.getMaestro().getNombre() + ".pdf";
            ficheroPDF = new FileOutputStream(modeloArchivos.getRutaDeGuardado().getAbsolutePath()+ "/" + nombreArchivoResultante);
            // Se asocia el documento de OutPutStream
            PdfWriter.getInstance(documento, ficheroPDF);          
            // Se abre el documento
            documento.open();
            
            // Parrafo
            Paragraph titulo = new Paragraph(curso.getAsignatura().getNombre() + "\n" + curso.getMaestro().getNombre() + " " +  curso.getMaestro().getApellido() + "\n\n",
                    FontFactory.getFont("arial",
                            18,
                            Font.BOLD
                    )
            );
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            // Añadimos el titulo al documento
            documento.add(titulo);
            
            // Creamos una tabla
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Id");
            tabla.addCell("Nombre");
            tabla.addCell("Asistencia");

            for (int i = 0; i < listaAlumnos.size(); i++) {
                tabla.addCell("" + i);
                tabla.addCell(listaAlumnos.get(i));
                tabla.addCell(" ");
            }
            
            // Añadimos la tabla al documento
            documento.add(tabla);
            
            // Se cierra el documento
            documento.close();
        } catch (DocumentException ex) {
            Logger.getLogger(CtrlGenerarListasAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CtrlGenerarListasAsistencia.class.getName()).log(Level.SEVERE, null, ex);
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
