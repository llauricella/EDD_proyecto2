/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edd_proyecto2;

import EstructurasDeDatos.Arbol;
import EstructurasDeDatos.LecturaJson;
import java.io.IOException;

/**
 *
 * @author lalau
 */

public class EDD_proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        LecturaJson read = new LecturaJson();
        Arbol arbol = read.LecturaJson();
        System.out.println(arbol.descendientesPorGeneracion(10).printList());
    }
    
}
