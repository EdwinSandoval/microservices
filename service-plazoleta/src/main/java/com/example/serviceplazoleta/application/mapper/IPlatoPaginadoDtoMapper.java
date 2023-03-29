package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.response.Plato.PlatoPaginadoResponseDto;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlatoPaginadoDtoMapper {
//    @Mappings({
//            @Mapping(target = "categoria", source = "categoria.idCategoria"),
//    })
    List<PlatoPaginadoResponseDto> toPlatoPaginado(List<PlatoModel> platoModels);
}
