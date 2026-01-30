package cl.speedfast.model;

import cl.speedfast.Interfaces.Cancelable;
import cl.speedfast.Interfaces.Despachable;
import cl.speedfast.Interfaces.Rastreable;

import java.util.List;

public class PedidoComida extends Pedido implements Despachable, Cancelable, Rastreable {

    public PedidoComida(String idPedido, String direccionEntrega, String tipoPedido, Double distanciaKm) {
        super(idPedido, direccionEntrega, tipoPedido, distanciaKm);
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("\n[Pedido de Comida]");
        System.out.println("Pedido #" + getIdPedido());
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        setRepartidor(nombreRepartidor);
        System.out.println("Repartidor asignado: " + nombreRepartidor);
    }

    @Override
    public void calcularTiempoEntrega() {
        int tiempoBase = 15;
        int tiempoDistancia = 0;
        if (getDistanciaKm() > 1){
            tiempoDistancia = (int) Math.round(getDistanciaKm() * 2);
        }
        int tiempoEntrega = tiempoBase + tiempoDistancia;
        System.out.println("Tiempo estimado de entrega: " + tiempoEntrega + " minutos");
    }

    @Override
    public void despachar() {
        System.out.println("PedidoComida despachado correctamente.");
        registrarEvento("PedidoComida #" + getIdPedido() + " - entregado por " + getRepartidor());
    }

    @Override
    public void cancelar() {
        System.out.println("\n[Pedido de Comida]");
        System.out.println("Cancelando PedidoComida #" + getIdPedido() + "...");
        System.out.println("Su pedido fue cancelado con éxito.");
    }

    @Override
    public List<String> verHistorial() {
        return getHistorial();
    }
}
