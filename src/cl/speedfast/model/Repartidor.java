package cl.speedfast.model;

import cl.speedfast.gestor.EstadisticaPedidos;
import cl.speedfast.gestor.ZonaDeCarga;

public class Repartidor implements Runnable {

    private String nombreRepartidor;
    public ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombreRepartidor, ZonaDeCarga zonaDeCarga) {
        this.nombreRepartidor = nombreRepartidor;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public ZonaDeCarga getZonaDeCarga() {
        return zonaDeCarga;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public void setZonaDeCarga(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        System.out.println("[Repartidor " + nombreRepartidor + "] ha comenzado sus entregas. ("+ Thread.currentThread().getName() + ")"); //ver que imprime el nombre del hilo

        while(true){
            // Retirar un pedido de la zona de carga
            Pedido pedido = zonaDeCarga.retirarPedido();

            // Si no hay más pedidos, salir del bucle
            if (pedido == null) {
                System.out.println("[Repartidor " + nombreRepartidor + "] No quedan más pedidos en la lista");
                break;
            }

            try {
                // Cambiar estado a EN_REPARTO
                pedido.setEstadoPedido(EstadoPedido.EN_REPARTO);
                System.out.println("[Repartidor " + nombreRepartidor + "] En camino con pedido: " + pedido.getTipoPedido() + " #" + pedido.getIdPedido());

                // Simular tiempo de entrega
                pedido.calcularTiempoEntrega();
                //pedido.mostrarResumen();

                long tiempoEntregaMs = (long) (pedido.getDistanciaKm() * 200); // Simulación: 200 ms por km
                Thread.sleep(tiempoEntregaMs);

                // Cambiar estado a ENTREGADO
                pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
                System.out.println("[Repartidor " + nombreRepartidor + "] Ha entregado el pedido #: " + pedido.getIdPedido() + " (estado: " + pedido.getEstadoPedido() + ")");

                //Incrementamos pedidos con AtomicInteger
                EstadisticaPedidos.incrementarPedidosTotales();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor " + nombreRepartidor + "] Fue interrumpido durante el pedido #" + pedido.getIdPedido());
                break;
            }
        }

        System.out.println("[Repartidor " + nombreRepartidor + "] ha finalizado todas sus entregas.");
    }
}