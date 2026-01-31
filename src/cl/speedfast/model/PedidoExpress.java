package cl.speedfast.model;

import java.util.List;

public class PedidoExpress extends Pedido {

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
        System.out.println("#" + getIdPedido() + " --> Tiempo estimado de entrega: " + tiempoEntrega + " minutos");
    }

    @Override
    public void despachar() {
        if (getEstadoPedido() == EstadoPedido.CANCELADO){
            System.out.println("No se puede despachar PedidoExpress #" + getIdPedido() + " porque está cancelado.");
            return;
        }
        if (getEstadoPedido() == EstadoPedido.DESPACHADO){
            System.out.println("El PedidoExpress #" + getIdPedido() + " ya fue despachado.");
            return;
        }

        System.out.println("PedidoExpress despachado correctamente.");
        setEstadoPedido(EstadoPedido.DESPACHADO);
        registrarEvento("PedidoExpress #" + getIdPedido() + " - entregado por " + getRepartidor());
    }

    @Override
    public boolean cancelar(String motivoCancelacion) {
        if (getEstadoPedido() == EstadoPedido.DESPACHADO){
            System.out.println("No se puede cancelar PedidoExpress #" + getIdPedido() + " porque ya fue despachado.");
            return false;
        }
        if (getEstadoPedido() == EstadoPedido.CANCELADO){
            System.out.println("El PedidoExpress #" + getIdPedido() + " ya está cancelado.");
            return false;
        }

        System.out.println("\n[Pedido Express]");
        System.out.println("Cancelando PedidoExpress #" + getIdPedido() + "...");
        System.out.println("Motivo de cancelación: " + motivoCancelacion);
        System.out.println("Su pedido fue cancelado con éxito.");

        setEstadoPedido(EstadoPedido.CANCELADO);
        registrarEvento("PedidoExpress #" + getIdPedido() + " - cancelado. Motivo: " + motivoCancelacion);
        return true;
    }

    @Override
    public List<String> verHistorial() {
        return getHistorial();
    }
}
