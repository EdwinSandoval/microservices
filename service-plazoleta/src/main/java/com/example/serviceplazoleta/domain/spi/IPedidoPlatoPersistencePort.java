package com.example.serviceplazoleta.domain.spi;

import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.domain.model.Pedido_PlatosModel;

import java.util.List;

public interface IPedidoPlatoPersistencePort {
    void guardarPedidoPlato(Pedido_PlatosModel pedido_platosModel);

    List<Pedido_PlatosModel> listarPedidos();
}
