package cl.speedfast.model;

import java.util.ArrayList;
import java.util.List;

public class Repartidor implements Runnable {

    private String nombreRepartidor;
    public List<Pedido> pedidosAsignados = new ArrayList<>();

    public Repartidor(String nombreRepartidor, List<Pedido> pedidosAsignados) {
        this.nombreRepartidor = nombreRepartidor;
        this.pedidosAsignados = pedidosAsignados;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public List<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public void setPedidosAsignados(List<Pedido> pedidosAsignados) {
        this.pedidosAsignados = pedidosAsignados;
    }

    @Override
    public void run() {

        System.out.println("[Repartidor " + nombreRepartidor + "] ha comenzado sus entregas. ("+ Thread.currentThread().getName() + ")"); //ver que imprime el nombre del hilo

        for (Pedido pedido : pedidosAsignados) {
            try {
                System.out.println("[Repartidor " + nombreRepartidor + "] Entregando " + pedido.getTipoPedido() + " #" + pedido.getIdPedido() + "...");

                pedido.calcularTiempoEntrega();
                //pedido.mostrarResumen(); //<-- Profe, Dejo comentado el método para no ensuciar tanto la salida por consola.

                long tiempoEntregaMs = (long) (pedido.getDistanciaKm() * 200); // Simula tiempo de entrega basado en la distancia
                Thread.sleep(tiempoEntregaMs);
                System.out.println("[Repartidor " + nombreRepartidor + "] ha entregado el pedido #" + pedido.getIdPedido());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor " + nombreRepartidor + "] ha sido interrumpido durante el pedido #" + pedido.getIdPedido());
                return;
            }
        }
        System.out.println("[Repartidor " + nombreRepartidor + "] ha finalizado todas sus entregas.");
    }
}