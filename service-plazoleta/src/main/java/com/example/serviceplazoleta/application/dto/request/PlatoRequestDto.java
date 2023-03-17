package com.example.serviceplazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoRequestDto {

    private String nombre;

    private String descripcion;

    private float precio;

    private String urlImagen;

    private String activo;
}
