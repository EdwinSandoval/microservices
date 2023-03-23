package com.example.serviceplazoleta.application.dto.request;

import com.example.serviceplazoleta.application.dto.request.UserRestaurante.UserRestauranteRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RestauranteRequestDto {
    @NotBlank(message = "Ingrese el nombre")
    private String nombre;

    @NotBlank(message = "Ingrese la direccion")
    private String direccion;

    @NotBlank(message = "Ingrese el telefono, es obligatorio")
    @Pattern(regexp = "^[0-9]*$", message = "Debe ser numerico")
    private String telefono;

    @NotBlank(message = "Ingrese URL")
    private String urlLogo;

    @NotBlank(message = "Ingrese NIT")
    @Pattern(regexp = "^[0-9]*$", message = "Debe ser numerico")
    private String nit;

    @NotBlank(message = "Ingrese el id de Propietario")
    @Pattern(regexp = "^[0-9]*$", message = "Debe ser numerico")
    private Long idPropietario;
}
