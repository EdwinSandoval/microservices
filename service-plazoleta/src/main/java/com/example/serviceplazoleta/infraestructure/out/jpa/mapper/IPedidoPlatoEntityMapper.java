package com.example.serviceplazoleta.infraestructure.out.jpa.mapper;

import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.domain.model.Pedido_PlatosModel;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PedidoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.Pedido_PlatosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPedidoPlatoEntityMapper {
    Pedido_PlatosEntity toEntity(Pedido_PlatosModel pedidoModel);
    Pedido_PlatosModel toPedidoModel(Pedido_PlatosEntity pedidoEntity);
    List<Pedido_PlatosModel> toPedidoModelList(List<Pedido_PlatosEntity> pedidoEntityList);
}
