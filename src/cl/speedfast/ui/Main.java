package cl.speedfast.ui;

import cl.speedfast.model.PedidoComida;
import cl.speedfast.model.PedidoEncomienda;
import cl.speedfast.model.PedidoExpress;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> historialEntrega = new ArrayList<>();

        PedidoComida p1 = new PedidoComida("PC001","Avenida Concepción 1234","Comida",7.1);
        p1.mostrarResumen();
        p1.asignarRepartidor("Felipe");
        p1.calcularTiempoEntrega();
        p1.despachar();
        historialEntrega.addAll(p1.verHistorial());


        PedidoEncomienda p2 = new PedidoEncomienda("PE002", "Los Alamos 186", "Encomienda",4.6);
        p2.mostrarResumen();
        p2.asignarRepartidor("Gustavo");
        p2.calcularTiempoEntrega();
        p2.despachar();
        historialEntrega.addAll(p2.verHistorial());


        PedidoExpress p3 = new PedidoExpress("PX003", "Pasaje San Ambrosio 291", "Express",0.5);
        p3.mostrarResumen();
        p3.asignarRepartidor("Matias");
        p3.calcularTiempoEntrega();
        p3.cancelar();


        System.out.println("\n======......Historial......======");
        for (String evento : historialEntrega){
            System.out.println("- " + evento);
        }


    }
}