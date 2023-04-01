package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.PedidoPlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PedidoPlatoResponseDto;

import java.util.List;

public interface IPedidoPlatoHandler {
    void guardarPedidoPlato(PedidoPlatoRequestDto pedidoPlatoRequestDto);

    List<PedidoPlatoResponseDto> listarPedidos();
}
