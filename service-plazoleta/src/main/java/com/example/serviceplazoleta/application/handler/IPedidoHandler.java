package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.PedidoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PedidoResponseDto;

import java.util.List;

public interface IPedidoHandler {

    void guardarPedido(PedidoRequestDto pedidoRequestDto);

    List<PedidoResponseDto> listarPedidos();
}
