package com.example.serviceplazoleta.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PedidoResponseDto {

    private Long id;

    private Long idCliente;

    private Date fecha;

    private String estado;

    private Long idChef;

    private Long restaurant;
}
