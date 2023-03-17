package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IRestauranteRequestMapper {
    RestauranteModel toRestaurante(RestauranteRequestDto restauranteRequestDto);
}
