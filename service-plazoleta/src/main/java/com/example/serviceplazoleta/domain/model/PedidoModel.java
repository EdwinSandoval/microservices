package com.example.serviceplazoleta.domain.model;



import java.util.Date;


public class PedidoModel {

    private Long id;
    private Long idCliente;
    private Date fecha;
    private String estado;
    private Long idChef;
    private RestauranteModel restaurant;

    public PedidoModel(Long id, Long idCliente, Date fecha, String estado, Long idChef, RestauranteModel restaurant) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.estado = estado;
        this.idChef = idChef;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdChef() {
        return idChef;
    }

    public void setIdChef(Long idChef) {
        this.idChef = idChef;
    }

    public RestauranteModel getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestauranteModel restaurant) {
        this.restaurant = restaurant;
    }

    public PedidoModel() {
    }
}
