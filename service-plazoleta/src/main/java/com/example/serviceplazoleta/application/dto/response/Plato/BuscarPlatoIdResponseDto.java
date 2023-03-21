package com.example.serviceplazoleta.application.dto.response.Plato;

import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuscarPlatoIdResponseDto {

//    private Long id;

    private String nombre;

    private String descripcion;

    private int precio;

    private String urlImagen;

    private boolean activo;

}
