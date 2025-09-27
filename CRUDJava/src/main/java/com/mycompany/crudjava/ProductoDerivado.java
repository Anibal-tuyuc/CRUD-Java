/*
Programador: Junior Anibal Tuyuc Cux
Ciudad de Guatemala 26 de Septiembre de 2025
1990-22-15370 Programación 2 Sección A
 */

package com.mycompany.crudjava;


public class ProductoDerivado extends Producto {
    // Encapsulamiento: Atributo específico private
    private double impuestoExtra;

    // Constructor: llama al constructor del padre usando super()
    public ProductoDerivado(String codigo, String nombre, double precioBase, double impuestoExtra) {
        super(codigo, nombre, precioBase);
        this.impuestoExtra = impuestoExtra;
    }

    // Polimorfismo: Sobreescritura del método
    @Override
    public double calcularPrecioVenta() {
        // Calcula el precio base del padre y añade el impuesto extra
        return super.calcularPrecioVenta() + impuestoExtra;
    }
    
    // Getter/Setter específico (public)
    public double getImpuestoExtra() { return impuestoExtra; }
    // ...
    
    @Override
    public String toString() {
        return super.toString() + "," + impuestoExtra; // Para guardar en archivo
    }
}
