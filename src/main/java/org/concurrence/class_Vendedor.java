package org.concurrence;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

// Clase que representa a un vendedor, que implementa la interfaz Runnable para poder ejecutarse como un hilo
public class class_Vendedor  implements Runnable {
    // Atributo que indica el nombre de la caja registradora
    String nombre;
    // Atributo que indica la cola de clientes que espera ser atendida por este vendedor
    ConcurrentLinkedQueue<class_Cliente> cola;

    // Constructor que recibe el número de la caja y la cola de clientes
    public class_Vendedor(String nombre, ConcurrentLinkedQueue<class_Cliente> cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    // Método que se ejecuta cuando se inicia el hilo
    @Override
    public void run() {
    // Mientras haya clientes en la cola
        while (!cola.isEmpty()) {
            // Sacar al primer cliente de la cola
            class_Cliente cliente = cola.poll();
            long timeStart = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            // Mostrar un mensaje indicando que se va a atender al cliente
            System.out.println("El vendedor " + nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + " EN EL TIEMPO: " + (timeStart -TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
            // Obtener el array de productos del cliente
            int[] productos = cliente.getProductos();
            // Recorrer el array de productos
            for (int i = 0; i < productos.length; i++) {
                // Obtener el producto actual
                int producto = productos[i];
                long timeStartProcessProcces = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                // Mostrar un mensaje indicando que se va a procesar el producto
                 System.out.println("Procesando el producto " + producto + " del cliente " + cliente.getNombre() + "-> Tiempo: " + (timeStartProcessProcces - timeStart));
                // Simular que se tarda 2 segundos en procesar el producto
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long timeEnd = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            // Mostrar un mensaje indicando que se ha terminado de atender al cliente
            System.out.println("El vendedor " + nombre + " ha terminado de procesar al cliente " + cliente.getNombre() +
                    " EN EL TIEMPO: " + (timeEnd - timeStart));
        }
        // Mostrar un mensaje indicando que no hay más clientes en la cola
        System.out.println("El vendedor " + nombre + " no tiene más clientes en la cola");
    }
}
