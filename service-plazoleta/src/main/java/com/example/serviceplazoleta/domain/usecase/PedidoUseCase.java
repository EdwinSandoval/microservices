package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.domain.api.IPedidoServicePort;
import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.domain.spi.IPedidoPersistencePort;

import java.util.List;

public class PedidoUseCase implements IPedidoServicePort {

    private final IPedidoPersistencePort pedidoPersistencePort;

    public PedidoUseCase(IPedidoPersistencePort pedidoPersistencePort) {
        this.pedidoPersistencePort = pedidoPersistencePort;
    }

    @Override
    public void guardarPedido(PedidoModel pedidoModel) {
        pedidoPersistencePort.guardarPedido(pedidoModel);
    }

    @Override
    public List<PedidoModel> listarPedidos() {
        return pedidoPersistencePort.listarPedidos();
    }
}
