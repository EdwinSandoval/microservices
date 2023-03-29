package com.example.serviceplazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ListarRestauranteRequestDto {
    private Long cantidad;

    private Long paginas;
    @NotBlank(message = "el campo es clasificacion es obligatorio")
    private String clasificacion;
}
