package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.Pedido_PlatosModel;
import com.example.serviceplazoleta.domain.spi.IPedidoPlatoPersistencePort;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.Pedido_PlatosEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPedidoPlatoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPedidoPlatoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PedidoPlatoJpaAdapter implements IPedidoPlatoPersistencePort {

    private final IPedidoPlatoRepository pedidoPlatoRepository;
    private final IPedidoPlatoEntityMapper pedidoPlatoEntityMapper;

    @Override
    public void guardarPedidoPlato(Pedido_PlatosModel pedido_platosModel) {
        Pedido_PlatosEntity pedidoEntity = pedidoPlatoRepository.save(pedidoPlatoEntityMapper.toEntity(pedido_platosModel));
        pedidoPlatoEntityMapper.toPedidoModel(pedidoEntity);
    }

    @Override
    public List<Pedido_PlatosModel> listarPedidos() {
        List<Pedido_PlatosEntity> entityList = pedidoPlatoRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return pedidoPlatoEntityMapper.toPedidoModelList(entityList);
    }
}
