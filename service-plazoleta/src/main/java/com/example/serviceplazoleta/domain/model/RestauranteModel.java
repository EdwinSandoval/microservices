package com.example.serviceplazoleta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class RestauranteModel {

    private Long idRestaurante;
    private String nombre;
    private String direccion;
    private String telefono;
    private String urlLogo;
    private String nit;
    private Long idPropietario;

    public RestauranteModel(Long idRestaurante, String nombre, String direccion, String telefono, String urlLogo, String nit, Long idPropietario) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.urlLogo = urlLogo;
        this.nit = nit;
        this.idPropietario = idPropietario;
    }

    public RestauranteModel() {
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public boolean validarNit(){
        return this.nit.matches("[0-9]*");
    }

    public boolean validarTelefono(){
        return this.telefono.matches("/d");
    }

    public boolean numeroTelefonoValido(){
        String numero=this.telefono;
        if ((numero.substring(0,1).equals("+") && numero.substring(1,numero.length()).matches("[0-9]*")) ||
                numero.substring(0,numero.length()).matches("[0-9]*")  ){
            return true;
        }
        return false;
    }

    public boolean validarNombre(){
        if ((this.nombre.matches(".*\\d.*") && this.nombre.matches(".*[a-zA-Z].*")) || this.nombre.matches(".*[a-zA-Z].*")){
            return true;
        }
        return false;
    }
}
