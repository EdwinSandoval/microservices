package com.example.serviceplazoleta.application.dto.response.Plato;

import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoPaginadoResponseDto {


    private String nombre;

    private String descripcion;

    private int precio;

    private String urlImagen;

    private boolean activo;


}
