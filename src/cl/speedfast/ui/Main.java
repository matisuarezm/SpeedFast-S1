package cl.speedfast.ui;

import cl.speedfast.gestor.EstadisticaPedidos;
import cl.speedfast.gestor.ZonaDeCarga;
import cl.speedfast.model.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


        System.out.println("=== Sistema de Gestión de Pedidos SpeedFast ===");

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        zonaDeCarga.agregarPedido(new PedidoComida("PC001","Avenida Concepción 1234","Comida",7.1));
        zonaDeCarga.agregarPedido(new PedidoEncomienda("PE002", "Los Alamos 186", "Encomienda",4.6));
        zonaDeCarga.agregarPedido(new PedidoExpress("PX003", "Pasaje San Ambrosio 291", "Express",0.5));
        zonaDeCarga.agregarPedido(new PedidoComida("PC004","Calle Falsa 123","Comida",2.3));
        zonaDeCarga.agregarPedido(new PedidoEncomienda("PE005", "Avenida Siempre Viva 742", "Encomienda",10.0));
        zonaDeCarga.agregarPedido(new PedidoExpress("PX006", "Calle Luna 456", "Express",6.2));

        Repartidor r1 = new Repartidor("Juan Perez",zonaDeCarga);
        Repartidor r2 = new Repartidor("Maria Gomez",zonaDeCarga);
        Repartidor r3 = new Repartidor("Carlos Ruiz",zonaDeCarga);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("[Main] Algunos repartidores no finalizaron correctamente.");
            }
        } catch (InterruptedException e) {
            System.out.println("[Main] Interrupción durante la espera de finalización de repartidores.");
            executor.shutdownNow();
            //Thread.currentThread().interrupt();
        }

        System.out.println("\n=== Total de pedidos entregados: " + EstadisticaPedidos.getPedidosTotales() + " ===");
        System.out.println("=== Sistema SpeedFast finalizado. Todas las entregas han sido procesadas. ===");
    }
}