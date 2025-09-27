/*
Programador: Junior Anibal Tuyuc Cux
Ciudad de Guatemala 26 de Septiembre de 2025
1990-22-15370 Programación 2 Sección A
 */
package com.mycompany.crudjava;

public class Producto {
    // Encapsulamiento: Atributos private
    private String codigo;
    private String nombre;
    protected double precioBase; // protected para permitir acceso directo en clases hijas si es necesario

    // Constructor public
    public Producto(String codigo, String nombre, double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Abstracción y Encapsulamiento: Métodos public (Getters y Setters)
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() {
        return nombre;
    }
    public double getPrecioBase() { return precioBase; } // Necesario para mostrar el precio actual
    public void setPrecioBase(double nuevoPrecio) {
        this.precioBase = nuevoPrecio;
    }
    


    // Polimorfismo: Método que será sobrescrito en clases hijas
    public double calcularPrecioVenta() {
        // Precio base + un margen general (ej. 10%)
        return precioBase * 1.10; 
    }
    
    @Override
    public String toString() {
        return codigo + "," + nombre + "," + precioBase; // Para guardar en archivo plano
    }
}
