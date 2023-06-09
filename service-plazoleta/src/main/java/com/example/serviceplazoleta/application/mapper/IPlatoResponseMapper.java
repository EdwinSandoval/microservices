package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.Plato.PlatoPaginadoResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IPlatoResponseMapper {
    PlatoResponseDto toResponse(PlatoModel platoModel);

    List<PlatoResponseDto> toResponseList(List<PlatoModel> platoModelList);

    BuscarPlatoIdResponseDto toResponseId(PlatoModel platoModel);//
    List<PlatoPaginadoResponseDto> toPlatoPaginado(List<PlatoModel> platoModels);
    List<PlatoModel> toPlatoPage(Page<PlatoModel> platoModels);
}
