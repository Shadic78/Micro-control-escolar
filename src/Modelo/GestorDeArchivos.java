/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Usuario
 */
public class GestorDeArchivos {

    private JFileChooser chooser;

    public File cargarArchivo() {
        File archivo = null;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Cargar archivo");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            archivo = chooser.getSelectedFile();
        } else {
            System.out.println("No se escogio un archivo ");
        }

        return archivo;
    }

    public File seleccionarDirectorio() {
        File archivo = null;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Cargar archivo");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            archivo = chooser.getSelectedFile();
        } else {
            System.out.println("No se escogio un archivo ");
        }

        return archivo;
    }

    public String leerArchivo(String rutaArchivo) {
        BufferedReader reader;
        String linea = "";
        String texto = "";
        try {
            reader = new BufferedReader(new FileReader(rutaArchivo));
            linea = reader.readLine();
            while (linea != null) {
                texto += linea + "\n";
                linea = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return texto;
    }

    public ArrayList<String> getLineasArchivo(String rutaArchivo) {
        BufferedReader reader;
        ArrayList<String> lineas = new ArrayList<String>();
        String linea = "";
        try {
            reader = new BufferedReader(new FileReader(rutaArchivo));
            linea = reader.readLine();
            while (linea != null) {
                lineas.add(linea);
                linea = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public void addTextoArchivo(String texto, String rutaArchivo) throws IOException {
        if (existeArchivo(rutaArchivo)) {
            FileWriter writer = new FileWriter(rutaArchivo, true);
            BufferedWriter bw = new BufferedWriter(writer);
            if (getLineasArchivo(rutaArchivo).size() > 0) {
                bw.write("\n" + texto);
            } else {
                bw.write(texto);
            }
            bw.close();
            writer.close();
        } else {
            //System.out.println("no existe el archivo");
            FileWriter writer = new FileWriter(rutaArchivo);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(texto);
            bw.close();
            writer.close();
        }
    }

    public boolean existeArchivo(String rutaArchivo) {
        boolean existe = false;
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            existe = true;
        }
        return existe;
    }

}
