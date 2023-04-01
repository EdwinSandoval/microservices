package com.example.serviceplazoleta.domain.api;

import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.domain.model.Pedido_PlatosModel;

import java.util.List;

public interface IPedidoPlatoServicePort {

    void guardarPedidoPlato(Pedido_PlatosModel pedido);

    List<Pedido_PlatosModel> listarPedidos();
}
