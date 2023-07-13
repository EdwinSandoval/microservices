package com.example.serviceplazoleta.application.dto.response.Restaurante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ObtenerRestauranteIdResponseDto {

    private String nombre;

    private String direccion;

    private String telefono;

    private String urlLogo;

    private String nit;
//
    private Long idPropietario;
}
