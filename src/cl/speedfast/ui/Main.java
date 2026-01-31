package cl.speedfast.ui;

import cl.speedfast.model.*;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


        System.out.println("=== Sistema de Gestión de Pedidos SpeedFast ===");

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new PedidoComida("PC001","Avenida Concepción 1234","Comida",7.1));
        pedidos.add(new PedidoEncomienda("PE002", "Los Alamos 186", "Encomienda",4.6));
        pedidos.add(new PedidoExpress("PX003", "Pasaje San Ambrosio 291", "Express",0.5));
        pedidos.add(new PedidoComida("PC004","Calle Falsa 123","Comida",2.3));
        pedidos.add(new PedidoEncomienda("PE005", "Avenida Siempre Viva 742", "Encomienda",10.0));
        pedidos.add(new PedidoExpress("PX006", "Calle Luna 456", "Express",6.2));

        List<Pedido> pedidosR1 = pedidos.subList(0,2);
        List<Pedido> pedidosR2 = pedidos.subList(2,4);
        List<Pedido> pedidosR3 = pedidos.subList(4,6);

        Repartidor r1 = new Repartidor("Juan Perez",pedidosR1);
        Repartidor r2 = new Repartidor("Maria Gomez",pedidosR2);
        Repartidor r3 = new Repartidor("Carlos Ruiz",pedidosR3);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("[Main] Algunos repartidores no finalizaron correctamente.");
            }
        } catch (InterruptedException e) {
            System.out.println("[Main] Interrupción durante la espera de finalización de repartidores.");
            executor.shutdownNow();
            //Thread.currentThread().interrupt();
        }

        System.out.println("=== Sistema SpeedFast finalizado. Todas las entregas han sido procesadas. ===");

    }
}