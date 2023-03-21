package com.example.serviceplazoleta.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoResponseDto {

    private Long id;

    private String nombre;

    private String descripcion;

    private int precio;

    private String urlImagen;

    private boolean activo;

    private CategoriaResponseDto categoria;

    private RestauranteResponseDto restaurant;
}
