package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.domain.spi.IPedidoPersistencePort;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PedidoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPedidoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPedidoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PedidoJpaAdapter implements IPedidoPersistencePort {

    private final IPedidoRepository pedidoRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;
    @Override
    public PedidoModel guardarPedido(PedidoModel pedidoModel) {
        PedidoEntity pedidoEntity = pedidoRepository.save(pedidoEntityMapper.toEntity(pedidoModel));
        return pedidoEntityMapper.toPedidoModel(pedidoEntity);
    }

    @Override
    public List<PedidoModel> listarPedidos() {
        List<PedidoEntity> entityList = pedidoRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return pedidoEntityMapper.toPedidoModelList(entityList);
    }
}
