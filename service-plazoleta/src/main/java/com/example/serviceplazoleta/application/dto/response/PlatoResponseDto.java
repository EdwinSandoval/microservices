package com.example.serviceplazoleta.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoResponseDto {

    private Long id;

    private String nombre;

    private String descripcion;

    private float precio;

    private String urlImagen;

    private String activo;
}
