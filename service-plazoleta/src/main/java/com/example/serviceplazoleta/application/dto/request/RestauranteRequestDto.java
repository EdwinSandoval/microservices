package com.example.serviceplazoleta.application.dto.request;

import com.example.serviceplazoleta.application.dto.request.UserRestaurante.UserRestauranteRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteRequestDto {

    private String nombre;

    private String direccion;

    private String telefono;

    private String urlLogo;

    private String nit;

    private UserRestauranteRequestDto propietarioId;
}
