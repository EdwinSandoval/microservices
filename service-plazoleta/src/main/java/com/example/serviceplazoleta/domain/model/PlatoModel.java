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

    private float precio;

    private String urlImagen;

    private String activo;
}
