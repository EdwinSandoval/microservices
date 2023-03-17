package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoriaResponseMapper {
    CategoriaResponseDto toResponse(CategoriaModel categoriaModel);

    List<CategoriaResponseDto> toResponseList(List<CategoriaModel> categoriaModelList);
}
