package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.request.CategoriaRequestDto;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoriaRequestMapper {

    CategoriaModel toCategoria(CategoriaRequestDto categoriaRequestDto);
}
