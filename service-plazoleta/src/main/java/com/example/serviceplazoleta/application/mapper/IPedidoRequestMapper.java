package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.request.PedidoRequestDto;
import com.example.serviceplazoleta.domain.model.PedidoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IPedidoRequestMapper {
        @Mappings({
            @Mapping(target = "restaurant.idRestaurante", source = "idRestaurante"),
    })
    PedidoModel toPedido(PedidoRequestDto pedidoRequestDto);
}
