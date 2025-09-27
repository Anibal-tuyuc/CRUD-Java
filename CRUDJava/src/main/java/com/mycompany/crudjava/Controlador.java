/*
Programador: Junior Anibal Tuyuc Cux
Ciudad de Guatemala 26 de Septiembre de 2025
1990-22-15370 Programación 2 Sección A
*/
package com.mycompany.crudjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private List<Producto> productos;

    public Controlador() {
        productos = new ArrayList<>();
        cargarProductos(); // Cargar al inicio
    }

    public void cargarProductos() {
        try {
            List<String> lineas = ArchivoUtil.leer();
            productos.clear();
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    productos.add(new Producto(partes[0], partes[1], Double.parseDouble(partes[2])));
                } else if (partes.length == 4) {
                    productos.add(new ProductoDerivado(partes[0], partes[1], Double.parseDouble(partes[2]), Double.parseDouble(partes[3])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }
    
    // Método para guardar la lista actual de productos en el archivo
    public void guardarProductos() {
        try {
            List<String> lineas = new ArrayList<>();
            for (Producto p : productos) {
                lineas.add(p.toString());
            }
            ArchivoUtil.guardar(lineas);
        } catch (IOException e) {
            System.err.println("Error al guardar datos: " + e.getMessage());
        }
    }

    // Mostrar precios aplicando polimorfismo
    public void mostrarPrecios() {
        for (Producto p : productos) {
            System.out.println("Producto: " + p.getNombre() + ", Precio Venta: " + p.calcularPrecioVenta());
        }
    }
    
    // Modificar Precio 
    public boolean modificarPrecio(String codigo, double nuevoPrecio) {
        Producto p = buscarProducto(codigo);
        if (p != null) {
            p.setPrecioBase(nuevoPrecio); 
            guardarProductos(); 
            System.out.println("✅ Precio del producto " + codigo + " modificado a $" + nuevoPrecio);
            return true;
        }
        System.out.println("🚫 Error: Producto con código " + codigo + " no encontrado.");
        return false;
    } // Cierre modificarPrecio

    // Eliminar Producto
    public boolean eliminarProducto(String codigo) {
        boolean eliminado = productos.removeIf(p -> p.getCodigo().equalsIgnoreCase(codigo));
        if (eliminado) {
            guardarProductos(); // Persistir el cambio
            System.out.println("🗑️ Producto con código " + codigo + " eliminado y archivo actualizado.");
        } else {
            System.out.println("🚫 Error: Producto con código " + codigo + " no encontrado para eliminar.");
        }
        return eliminado;
    } // Cierre eliminarProducto
    
    //Metodo Agregar Producto
    public void agregarProducto(Producto p) {
        if (buscarProducto(p.getCodigo()) == null) {
            this.productos.add(p);
            guardarProductos(); // Persistir el cambio
            System.out.println("✅ Producto agregado correctamente.");
        } else {
            System.out.println("🚫 Error: Ya existe un producto con el código " + p.getCodigo());
        }
    } // Cierre Agregar Producto
    
    // Método para buscar
    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    } // Clase Publica Controlador
    
} // Fin de clase Controlador