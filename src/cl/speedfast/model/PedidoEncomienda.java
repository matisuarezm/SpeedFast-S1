package cl.speedfast.model;

import cl.speedfast.Interfaces.Cancelable;
import cl.speedfast.Interfaces.Despachable;
import cl.speedfast.Interfaces.Rastreable;

import java.util.List;

public class PedidoEncomienda extends Pedido implements Despachable, Cancelable, Rastreable {

    public PedidoEncomienda(String idPedido, String direccionEntrega, String tipoPedido, Double distanciaKm) {
        super(idPedido, direccionEntrega, tipoPedido, distanciaKm);
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("\n[Pedido de Encomienda]");
        System.out.println("Pedido #" + getIdPedido());
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        setRepartidor(nombreRepartidor);
        System.out.println("Repartidor asignado: " + nombreRepartidor);
    }

    @Override
    public void calcularTiempoEntrega() {
        int tiempoBase = 20;
        int tiempoDistancia = 0;
        tiempoDistancia = (int) Math.round(getDistanciaKm() * 1.5) ;
        int tiempoEntrega = tiempoBase + tiempoDistancia;
        System.out.println("Tiempo estimado de entrega: " + tiempoEntrega + " minutos");
    }

    @Override
    public void despachar() {
        System.out.println("PedidoEncomienda despachado correctamente.");
        registrarEvento("PedidoEncomienda #" + getIdPedido() + " - entregado por " + getRepartidor());
    }

    @Override
    public void cancelar() {
        System.out.println("\n[Pedido de Encomienda]");
        System.out.println("Cancelando PedidoEncomienda #" + getIdPedido() + "...");
        System.out.println("Su pedido fue cancelado con éxito.");
    }

    @Override
    public List<String> verHistorial() {
        return getHistorial();
    }
}
