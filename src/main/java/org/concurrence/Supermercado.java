package org.concurrence;

import java.util.concurrent.ConcurrentLinkedQueue;

// Clase principal que contiene el método main
public class Supermercado {
    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {

        // Se crear una cola de clientes con algunos ejemplos significará que varios cliente han comprado varios productos
        ConcurrentLinkedQueue<class_Cliente> cola = new ConcurrentLinkedQueue<>();
        cola.offer(new class_Cliente(new int[]{1, 3, 5, 8}, "Cliente_1"));
        cola.offer(new class_Cliente(new int[]{2, 4, 6, 9}, "Cliente_2"));
        //cola.offer(new class_Cliente(new int[]{7, 10, 11, 12}));

        // Crear dos vendedores que atienden las colas de clientes
        class_Vendedor vendedor1 = new class_Vendedor("Jennifer", cola);
        class_Vendedor vendedor2 = new class_Vendedor("Christian", cola);

        // Crear dos hilos para ejecutar los vendedores
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        // Esperar a que los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar un mensaje indicando que el programa ha terminado
        System.out.println("El programa ha terminado");
    }
}