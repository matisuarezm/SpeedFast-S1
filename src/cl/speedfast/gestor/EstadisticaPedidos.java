package cl.speedfast.gestor;

import java.util.concurrent.atomic.AtomicInteger;

public class EstadisticaPedidos {

    private static final AtomicInteger pedidosTotales = new AtomicInteger(0);

    public static void incrementarPedidosTotales() {
        pedidosTotales.incrementAndGet();
    }

    public static int getPedidosTotales() {
        return pedidosTotales.get();
    }

}

