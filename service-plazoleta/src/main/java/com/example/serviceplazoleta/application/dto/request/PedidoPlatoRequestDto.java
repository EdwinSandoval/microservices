package com.example.serviceplazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
@Getter
@Setter
public class PedidoPlatoRequestDto {



    @NotBlank(message = "El campo cantidad es obligatorio")
    private int cantidad;

    @NotBlank(message = "El campo idPlato es obligatorio")
    private Long idPlato;

    @NotBlank(message = "El campo idPedido es obligatorio")
    private Long idPedido;
}
