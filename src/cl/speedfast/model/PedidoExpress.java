package cl.speedfast.model;

import cl.speedfast.Interfaces.Cancelable;
import cl.speedfast.Interfaces.Despachable;
import cl.speedfast.Interfaces.Rastreable;

import java.util.List;

public class PedidoExpress extends Pedido implements Despachable, Cancelable, Rastreable {

    public PedidoExpress(String idPedido, String direccionEntrega, String tipoPedido, Double distanciaKm) {
        super(idPedido, direccionEntrega, tipoPedido, distanciaKm);
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("\n[Pedido Express]");
        System.out.println("Pedido #" + getIdPedido());
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        setRepartidor(nombreRepartidor);
        System.out.println("Repartidor asignado: " + nombreRepartidor);
    }

    @Override
    public void calcularTiempoEntrega() {
        int tiempoEntrega = 10;
        if (getDistanciaKm() > 5){
            tiempoEntrega += 5;
        }
        System.out.println("Tiempo estimado de entrega: " + tiempoEntrega + " minutos");
    }

    @Override
    public void despachar() {
        System.out.println("PedidoExpress despachado correctamente.");
        registrarEvento("PedidoExpress #" + getIdPedido() + " - entregado por " + getRepartidor());
    }

    @Override
    public void cancelar() {
        System.out.println("\n[Pedido Express]");
        System.out.println("Cancelando PedidoExpress #" + getIdPedido() + "...");
        System.out.println("Su pedido fue cancelado con éxito.");
    }

    @Override
    public List<String> verHistorial() {
        return getHistorial();
    }
}
