package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.response.PedidoResponseDto;
import com.example.serviceplazoleta.domain.model.PedidoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoResponseMapper {
    PedidoResponseDto toResponse(PedidoModel pedidoModel);

    List<PedidoResponseDto> toResponseList(List<PedidoModel> pedidoModelList);
}
