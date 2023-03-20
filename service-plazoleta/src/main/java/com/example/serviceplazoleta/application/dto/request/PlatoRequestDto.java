package com.example.serviceplazoleta.application.dto.request;

import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoRequestDto {

    private String nombre;

    private String descripcion;

    private float precio;

    private String urlImagen;

    private boolean activo=true;

    private PlatoCategoriaRequestdto categoria;

    private PlatoRestauranteRequestDto restaurante;

}
