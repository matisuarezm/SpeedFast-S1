package cl.speedfast.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Pedido{

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private double distanciaKm;
    private String repartidor;

    private List<String> historial = new ArrayList<>();

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido, double distanciaKm){
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
        this.distanciaKm = distanciaKm;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public double getDistanciaKm(){
        return distanciaKm;
    }

    public String getRepartidor(){
        return repartidor;
    }

    public List<String> getHistorial(){
        return new ArrayList<>(historial);
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public void setDistanciaKm(double distanciaKm){
        this.distanciaKm = distanciaKm;
    }

    public void setRepartidor(String repartidor){
        this.repartidor = repartidor;
    }

    public void asignarRepartidor(){
        System.out.println("El pedido fue asignado exitosamente a un repartido");
    }

    public void asignarRepartidor(String nombreRepartidor){
        this.repartidor = nombreRepartidor;
        System.out.println("El pedido fue asignado exitosamente al repartido: " + nombreRepartidor);
    }

    public void mostrarResumen(){
        System.out.println("\n[Pedido " + getTipoPedido() + "]");
        System.out.println("Pedido #" + getIdPedido());
        System.out.println("Dirección: " + getDireccionEntrega());
        System.out.println("Distancia: " + getDistanciaKm() + " Km");
    }

    public abstract void calcularTiempoEntrega();

    public void registrarEvento(String evento){
        historial.add(evento);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ID Pedido: ").append(getIdPedido()).append('\n');
        sb.append("Tipo Pedido: ").append(getTipoPedido()).append('\n');
        sb.append("Dirección: ").append(getDireccionEntrega()).append('\n');
        sb.append("Distancia: ").append(getDistanciaKm());

        return sb.toString();
    }

}
