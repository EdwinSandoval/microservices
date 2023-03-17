package com.example.serviceplazoleta.infraestructure.out.jpa.mapper;

import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPedidoEntityMapper {

    PedidoEntity toEntity(PedidoModel pedidoModel);
    PedidoModel toPedidoModel(PedidoEntity pedidoEntity);
    List<PedidoModel> toPedidoModelList(List<PedidoEntity> pedidoEntityList);
}
