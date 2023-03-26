package com.example.serviceplazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RestauranteRequestDto {
    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El campo direccion es obligatorio")
    private String direccion;

    @NotBlank(message = "El campo telefono es obligatorio")
    @Pattern(regexp = "^[0-9]*$", message = "El telefono debe ser numerico")
    private String telefono;

    @NotBlank(message = "El campo urlLogo es obligatorio")
    private String urlLogo;

    @NotBlank(message = "El campo nit es obligatorio")
    @Pattern(regexp = "^[0-9]*$", message = "El documento de identidad debe ser numerico")
    private String nit;

    @NotBlank(message = "El campo idPropietario es obligatorio")
    private Long idPropietario;
}
