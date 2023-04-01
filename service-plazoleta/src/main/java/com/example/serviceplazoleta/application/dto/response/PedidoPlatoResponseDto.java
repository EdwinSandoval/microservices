package com.example.serviceplazoleta.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoPlatoResponseDto {

    private int cantidad;

    private Long idPlato;

    private Long idPedido;
}
