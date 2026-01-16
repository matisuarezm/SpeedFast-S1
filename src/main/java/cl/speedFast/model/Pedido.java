package main.java.cl.speedFast.model;

public abstract class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private double distanciaKm;

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

    public Double getDistanciaKm(){
        return distanciaKm;
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

    public void asignarRepartidor(){
        System.out.println("El pedido fue asignado exitosamente a un repartido");
    }

    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("El pedido fue asignado exitosamente al repartido: " + nombreRepartidor);
    }

    public void mostrarResumen(){
        System.out.println("Pedido" + getTipoPedido() + " #" + getIdPedido());
        System.out.println("Dirección: " + getDireccionEntrega());
        System.out.println("Distancia: " + getDistanciaKm() + "Km");
    }

    public abstract void calcularTiempoEntrega();

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
