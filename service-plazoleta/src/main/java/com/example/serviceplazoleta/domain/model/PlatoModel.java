package com.example.serviceplazoleta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoModel {

    private Long id;

    private String nombre;

    private String descripcion;

    private int precio;

    private String urlImagen;

    private boolean activo;

    private CategoriaModel categoria;

    private RestauranteModel restaurant;


    public boolean precioMayorCero(){
        if (this.precio>0){
            return true;
        }
        return false;
    }
//    boolean precioMayorCero= (this.precio>0)? true:false;
}
