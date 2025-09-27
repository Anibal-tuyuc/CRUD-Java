/*
Programador: Junior Anibal Tuyuc Cux
Ciudad de Guatemala 26 de Septiembre de 2025
1990-22-15370 Programación 2 Sección A
 */

package com.mycompany.crudjava;


public class Cliente {
    private int id;
    private String nombre;
    private String direccion;

    public Cliente(int id, String nombre, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }
    
    // Getters y Setters (public)
    public int getId() { return id; }
    public void setNombre(String nombre) {}
    public String getNombre() {
        return nombre;
    }
}
