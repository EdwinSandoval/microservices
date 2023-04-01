package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.application.dto.request.PedidoPlatoRequestDto;
import com.example.serviceplazoleta.domain.api.IPedidoPlatoServicePort;
import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.domain.model.Pedido_PlatosModel;
import com.example.serviceplazoleta.domain.spi.IPedidoPlatoPersistencePort;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PedidoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.Pedido_PlatosEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPedidoPlatoEntityMapper;

import java.util.List;

public class PedidoPlatoUseCase implements IPedidoPlatoServicePort {

    private final IPedidoPlatoPersistencePort pedidoPlatoPersistencePort;
    private final IPedidoPlatoEntityMapper pedidoPlatoEntityMapper;

    public PedidoPlatoUseCase(IPedidoPlatoPersistencePort pedidoPlatoPersistencePort, IPedidoPlatoEntityMapper pedidoPlatoEntityMapper) {
        this.pedidoPlatoPersistencePort = pedidoPlatoPersistencePort;
        this.pedidoPlatoEntityMapper = pedidoPlatoEntityMapper;
    }


    @Override
    public void guardarPedidoPlato(Pedido_PlatosModel pedido_platosModel) {
        Pedido_PlatosEntity pedidoEntity=pedidoPlatoEntityMapper.toEntity(pedido_platosModel);
        pedidoPlatoPersistencePort.guardarPedidoPlato(pedido_platosModel);
    }



    @Override
    public List<Pedido_PlatosModel> listarPedidos() {
        return pedidoPlatoPersistencePort.listarPedidos();
    }
}
