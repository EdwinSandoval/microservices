package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.response.PedidoPlatoResponseDto;
import com.example.serviceplazoleta.domain.model.Pedido_PlatosModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoPlatoResponseMapper {

    @Mappings({
            @Mapping(target = "idPlato", source = "platos.id"),
            @Mapping(target = "idPedido",source = "pedido.id")
    })
    PedidoPlatoResponseDto toResponse(Pedido_PlatosModel pedido_platosModel);
    List<PedidoPlatoResponseDto> toResponseList(List<Pedido_PlatosModel> pedido_platosModels);
}
