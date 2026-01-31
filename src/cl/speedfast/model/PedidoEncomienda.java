package cl.speedfast.model;

import java.util.List;

public class PedidoEncomienda extends Pedido {

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
        System.out.println("#" + getIdPedido() + " --> Tiempo estimado de entrega: " + tiempoEntrega + " minutos");
    }

    @Override
    public void despachar() {
        if (getEstadoPedido() == EstadoPedido.CANCELADO){
            System.out.println("No se puede despachar PedidoEncomienda #" + getIdPedido() + " porque está cancelado.");
            return;
        }
        if (getEstadoPedido() == EstadoPedido.DESPACHADO){
            System.out.println("El PedidoEncomienda #" + getIdPedido() + " ya fue despachado.");
            return;
        }

        System.out.println("PedidoEncomienda despachado correctamente.");
        setEstadoPedido(EstadoPedido.DESPACHADO);
        registrarEvento("PedidoEncomienda #" + getIdPedido() + " - entregado por " + getRepartidor());
    }

    @Override
    public boolean cancelar(String motivoCancelacion) {
        if (getEstadoPedido() == EstadoPedido.DESPACHADO){
            System.out.println("No se puede cancelar PedidoEncomienda #" + getIdPedido() + " porque ya fue despachado.");
            return false;
        }
        if (getEstadoPedido() == EstadoPedido.CANCELADO){
            System.out.println("El PedidoEncomienda #" + getIdPedido() + " ya está cancelado.");
            return false;
        }

        System.out.println("\n[Pedido de Encomienda]");
        System.out.println("Cancelando PedidoEncomienda #" + getIdPedido() + "...");
        System.out.println("Motivo de cancelación: " + motivoCancelacion);
        System.out.println("Su pedido fue cancelado con éxito.");

        setEstadoPedido(EstadoPedido.CANCELADO);
        registrarEvento("PedidoEncomienda #" + getIdPedido() + " - cancelado. Motivo: " + motivoCancelacion);
        return true;
    }

    @Override
    public List<String> verHistorial() {
        return getHistorial();
    }
}
