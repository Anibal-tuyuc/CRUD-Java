/*
Programador: Junior Anibal Tuyuc Cux
Ciudad de Guatemala 26 de Septiembre de 2025
1990-22-15370 Programación 2 Sección A
 */
package com.mycompany.crudjava;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtil {
    private static final String NOMBRE_ARCHIVO = "datos.txt";

    // ✅ Guardar datos (escribir)
    public static void guardar(List<String> lineas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, false))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }

    // ✅ Leer datos
    public static List<String> leer() throws IOException {
        List<String> lineas = new ArrayList<>();
        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
             // Crear el archivo si no existe y evitar error de FileNotFound
             archivo.createNewFile(); 
             return lineas;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }
    
    // ✅ Modificar registros (debe ser implementado usando leer, modificar la lista, y luego guardar)
    // ✅ Eliminar registros (similar a modificar)
    // Estos métodos deben tomar la lógica de la capa de Control (Controlador.java)
}
