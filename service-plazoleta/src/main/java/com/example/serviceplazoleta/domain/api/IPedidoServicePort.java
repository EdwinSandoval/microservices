package com.example.serviceplazoleta.domain.api;

import com.example.serviceplazoleta.domain.model.PedidoModel;

import java.util.List;

public interface IPedidoServicePort {

    void guardarPedido(PedidoModel pedidoModel);

    List<PedidoModel> listarPedidos();
}
