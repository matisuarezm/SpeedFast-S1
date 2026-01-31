package cl.speedfast.model;

import java.util.List;

public class PedidoComida extends Pedido {

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
        System.out.println("#" + getIdPedido() + " --> Tiempo estimado de entrega: " + tiempoEntrega + " minutos.");
    }

    @Override
    public void despachar() {
        if (getEstadoPedido() == EstadoPedido.CANCELADO){
            System.out.println("No se puede despachar PedidoComida #" + getIdPedido() + " porque está cancelado.");
            return;
        }

        if (getEstadoPedido() == EstadoPedido.DESPACHADO){
            System.out.println("El PedidoComida #" + getIdPedido() + " ya fue despachado.");
            return;
        }

        System.out.println("PedidoComida despachado correctamente.");
        setEstadoPedido(EstadoPedido.DESPACHADO);
        registrarEvento("PedidoComida #" + getIdPedido() + " - entregado por " + getRepartidor());
    }

    @Override
    public boolean cancelar(String motivoCancelacion) {
        if (getEstadoPedido() == EstadoPedido.DESPACHADO){
            System.out.println("No se puede cancelar PedidoComida #" + getIdPedido() + " porque ya fue despachado.");
            return false;
        }
        if (getEstadoPedido() == EstadoPedido.CANCELADO){
            System.out.println("El PedidoComida #" + getIdPedido() + " ya está cancelado.");
            return false;
        }

        System.out.println("\n[Pedido de Comida]");
        System.out.println("Cancelando PedidoComida #" + getIdPedido() + "...");
        System.out.println("Motivo de cancelación: " + motivoCancelacion);
        System.out.println("Su pedido fue cancelado con éxito.");

        setEstadoPedido(EstadoPedido.CANCELADO);
        registrarEvento("PedidoComida #" + getIdPedido() + " - cancelado. Motivo: " + motivoCancelacion);
        return true;
    }

    @Override
    public List<String> verHistorial() {
        return getHistorial();
    }
}
