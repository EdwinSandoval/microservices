package com.example.serviceplazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Getter
@Setter
public class PedidoRequestDto {

    private Date fecha;

    @NotBlank(message = "El campo IdCliente es obligatorio")
    private Long idCliente;

    @NotBlank(message = "El campo idChef es obligatorio")
    private Long idChef;

    @NotBlank(message = "El campo idRestaurante es obligatorio")
    private Long idRestaurante;
}
