package com.example.serviceplazoleta.domain.model;

public class Pedido_PlatosModel {

    private Long idPedidoPlatos;
    private int cantidad;
    private PlatoModel platos;
    private PedidoModel pedido;

    public Pedido_PlatosModel(Long idPedidoPlatos, int cantidad, PlatoModel platos, PedidoModel pedido) {
        this.idPedidoPlatos = idPedidoPlatos;
        this.cantidad = cantidad;
        this.platos = platos;
        this.pedido = pedido;
    }

    public Long getIdPedidoPlatos() {
        return idPedidoPlatos;
    }

    public void setIdPedidoPlatos(Long idPedidoPlatos) {
        this.idPedidoPlatos = idPedidoPlatos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public PlatoModel getPlatos() {
        return platos;
    }

    public void setPlatos(PlatoModel platos) {
        this.platos = platos;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public Pedido_PlatosModel() {
    }
}
