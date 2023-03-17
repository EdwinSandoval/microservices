package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.PedidoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PedidoResponseDto;
import com.example.serviceplazoleta.application.handler.IPedidoHandler;
import com.example.serviceplazoleta.application.mapper.IPedidoRequestMapper;
import com.example.serviceplazoleta.application.mapper.IPedidoResponseMapper;
import com.example.serviceplazoleta.domain.api.IPedidoServicePort;
import com.example.serviceplazoleta.domain.model.PedidoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor//automaticamnete genera constructor a lo que hallamos definido como final
@Service//toma la clase como un bean y ya se puede inyectar
@Transactional
public class PedidoHandler  implements IPedidoHandler {

    private final IPedidoServicePort pedidoServicePort;
    private final IPedidoRequestMapper pedidoRequestMapper;
    private final IPedidoResponseMapper pedidoResponseMapper;


    @Override
    public void guardarPedido(PedidoRequestDto pedidoRequestDto) {
        PedidoModel pedidoModel = pedidoRequestMapper.toPedido(pedidoRequestDto);
        pedidoServicePort.guardarPedido(pedidoModel);
    }

    @Override
    public List<PedidoResponseDto> listarPedidos() {
        return pedidoResponseMapper.toResponseList(pedidoServicePort.listarPedidos());
    }
}
