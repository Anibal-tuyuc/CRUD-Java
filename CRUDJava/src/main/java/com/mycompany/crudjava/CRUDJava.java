/*
Programador: Junior Anibal Tuyuc Cux
Ciudad de Guatemala 26 de Septiembre de 2025
1990-22-15370 Programacion 2 Seccion A
*/

package com.mycompany.crudjava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CRUDJava {
    // Archivo: Main.java (Actualizado para el Menu CRUD)

    private static Scanner scanner = new Scanner(System.in);
    private static Controlador controlador = new Controlador();

    public static void main(String[] args) {
        int opcion = -1;

        while (opcion != 0) {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de linea
                procesarOpcion(opcion);
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = -1;
            }
        }
        System.out.println("Programa finalizado. Hasta pronto!");
        scanner.close(); // Cerrar el Scanner al finalizar
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENU DE GESTION DE PRODUCTOS =====");
        System.out.println("1. Crear nuevo producto (C)");
        System.out.println("2. Mostrar todos los productos (R - Read)");
        System.out.println("3. Modificar precio base (U - Update)");
        System.out.println("4. Eliminar producto por codigo (D - Delete)");
        System.out.println("5. Mostrar precios de venta (Polimorfismo)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearProducto();
                break;
            case 2:
                controlador.cargarProductos(); // Asegurar que se lea el archivo
                System.out.println("\n--- LISTADO DE PRODUCTOS EN ARCHIVO ---");
                controlador.mostrarPrecios();
                break;
            case 3:
                modificarProducto();
                break;
            case 4:
                eliminarProducto();
                break;
            case 5:
                System.out.println("\n--- CALCULO DE PRECIOS DE VENTA (POLIMORFISMO) ---");
                controlador.mostrarPrecios();
                break;
            case 0:
                break;
            default:
                System.out.println("Opcion no valida. Intente de nuevo.");
        }
    }

    // --- Logica de Captura de Datos para CREAR ---

    private static void crearProducto() {
        System.out.println("\n--- CREAR NUEVO PRODUCTO ---");
        System.out.print("Ingrese codigo (ej: A001): ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio base: ");
        double precioBase = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de linea

        System.out.print("Es Producto Derivado? (s/n): ");
        String tipo = scanner.nextLine();

        if (tipo.equalsIgnoreCase("s")) {
            System.out.print("Ingrese impuesto extra: ");
            double impuestoExtra = scanner.nextDouble();
            scanner.nextLine();

            // Creacion del objeto ProductoDerivado (Herencia)
            ProductoDerivado pd = new ProductoDerivado(codigo, nombre, precioBase, impuestoExtra);
            controlador.agregarProducto(pd);

        } else {
            // Creacion del objeto Producto Base (Abstraccion/Encapsulamiento)
            Producto p = new Producto(codigo, nombre, precioBase);
            controlador.agregarProducto(p);
        }
    }

    // --- Logica de Captura de Datos para MODIFICAR ---

    private static void modificarProducto() {
        System.out.println("\n--- MODIFICAR PRECIO BASE ---");
        System.out.print("Ingrese codigo del producto a modificar: ");
        String codigo = scanner.nextLine();

        Producto p = controlador.buscarProducto(codigo);
        if (p != null) {
            System.out.println("Producto encontrado: " + p.getNombre() + ". Precio actual: $" + p.getPrecioBase());
            System.out.print("Ingrese nuevo precio base: ");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            controlador.modificarPrecio(codigo, nuevoPrecio);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // --- Logica de Captura de Datos para ELIMINAR ---

    private static void eliminarProducto() {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");
        System.out.print("Ingrese codigo del producto a eliminar: ");
        String codigo = scanner.nextLine();

        controlador.eliminarProducto(codigo);
    }
}