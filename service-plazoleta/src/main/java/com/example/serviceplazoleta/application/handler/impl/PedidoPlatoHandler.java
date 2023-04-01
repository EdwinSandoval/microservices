package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.PedidoPlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PedidoPlatoResponseDto;
import com.example.serviceplazoleta.application.handler.IPedidoPlatoHandler;
import com.example.serviceplazoleta.application.mapper.IPedidoPlatoRequestMapper;
import com.example.serviceplazoleta.application.mapper.IPedidoPlatoResponseMapper;
import com.example.serviceplazoleta.domain.api.IPedidoPlatoServicePort;
import com.example.serviceplazoleta.domain.model.Pedido_PlatosModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@RequiredArgsConstructor//automaticamnete genera constructor a lo que hallamos definido como final
@Service//toma la clase como un bean y ya se puede inyectar
@Transactional

public class PedidoPlatoHandler implements IPedidoPlatoHandler {
    private final IPedidoPlatoServicePort pedidoPlatoServicePort;
    private final IPedidoPlatoRequestMapper pedidoPlatoRequestMapper;
    private final IPedidoPlatoResponseMapper pedidoPlatoResponseMapper;

    @Override
    public void guardarPedidoPlato(PedidoPlatoRequestDto pedidoPlatoRequestDto) {
        Pedido_PlatosModel pedidoModel = pedidoPlatoRequestMapper.toPedidoPlato(pedidoPlatoRequestDto);
        pedidoPlatoServicePort.guardarPedidoPlato(pedidoModel);
    }

    @Override
    public List<PedidoPlatoResponseDto> listarPedidos() {
        return pedidoPlatoResponseMapper.toResponseList(pedidoPlatoServicePort.listarPedidos());
    }
}
