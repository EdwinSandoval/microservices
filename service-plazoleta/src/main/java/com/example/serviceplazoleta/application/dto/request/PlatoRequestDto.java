package com.example.serviceplazoleta.application.dto.request;

import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class PlatoRequestDto {
    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El campo descripcion es obligatorio")
    private String descripcion;

    @Positive
    private int precio;

    @NotBlank (message = "El campo url es obligatorio")
    private String urlImagen;

    private boolean activo;
    @NotNull (message = "El campo idCategoria es obligatorio")
    private PlatoCategoriaRequestdto categoria;

    @NotNull (message = "El campo idRestaurante es obligatorio")
    private PlatoRestauranteRequestDto restaurant;


}
