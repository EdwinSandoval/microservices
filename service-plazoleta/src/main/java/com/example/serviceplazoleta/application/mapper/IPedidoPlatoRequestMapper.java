package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.request.PedidoPlatoRequestDto;

import com.example.serviceplazoleta.domain.model.Pedido_PlatosModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IPedidoPlatoRequestMapper {
    Pedido_PlatosModel toPedidoPlato(PedidoPlatoRequestDto pedidoRequestDto);
}
