package com.example.serviceplazoleta.domain.spi;

import com.example.serviceplazoleta.domain.model.PedidoModel;

import java.util.List;

public interface IPedidoPersistencePort {


    void guardarPedido(PedidoModel pedidoModel);

    List<PedidoModel> listarPedidos();
}
