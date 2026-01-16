package main.java.cl.speedFast.ui;

import main.java.cl.speedFast.model.Pedido;
import main.java.cl.speedFast.model.PedidoComida;
import main.java.cl.speedFast.model.PedidoEncomienda;
import main.java.cl.speedFast.model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        Pedido p1 = new PedidoComida("PC001","Avenida Concepción 1234","Comida",7.1);
        Pedido p2 = new PedidoEncomienda("PE002", "Los Alamos 186", "Encomienda",4.6);
        Pedido p3 = new PedidoExpress("PX003", "Pasaje San Ambrosio 291", "Express",6.0);

        System.out.println("======......LISTADO DE ENVÍOS......======");

        p1.mostrarResumen();
        p1.calcularTiempoEntrega();
        System.out.println();

        p2.mostrarResumen();
        p2.calcularTiempoEntrega();
        System.out.println();

        p3.mostrarResumen();
        p3.calcularTiempoEntrega();
        System.out.println();

    }
}