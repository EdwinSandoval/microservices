package com.example.serviceplazoleta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class PlatoModel {

    private Long id;
    private String nombre;
    private String descripcion;
    private int precio;
    private String urlImagen;
    private boolean activo;
    private CategoriaModel categoria;
    private RestauranteModel restaurant;

    public PlatoModel(Long id, String nombre, String descripcion, int precio, String urlImagen, boolean activo, CategoriaModel categoria, RestauranteModel restaurant) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.urlImagen = urlImagen;
        this.activo = activo;
        this.categoria = categoria;
        this.restaurant = restaurant;
    }

    public PlatoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public RestauranteModel getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestauranteModel restaurant) {
        this.restaurant = restaurant;
    }

    public boolean precioMayorCero(){
        return this.precio > 0;
    }
//    boolean precioMayorCero= (this.precio>0)? true:false;
}
