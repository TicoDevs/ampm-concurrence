package org.concurrence;
// Clase que representa a un cliente, con un array de enteros que indica los productos que ha comprado
public class class_Cliente {
    int[] productos;
    String nombre;

    // Constructor que recibe el array de productos
    public class_Cliente(int[] productos, String nombre) {
        this.productos = productos;
        this.nombre = nombre;
    }

    public int[] getProductos() {
        return productos;
    }

    public void setProductos(int[] productos) {
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
