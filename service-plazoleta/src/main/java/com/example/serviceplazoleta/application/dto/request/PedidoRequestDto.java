package com.example.serviceplazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PedidoRequestDto {

    private Date fecha;

    private boolean estado;
}
