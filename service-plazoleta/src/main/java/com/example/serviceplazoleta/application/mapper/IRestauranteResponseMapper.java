package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestauranteResponseMapper {
    RestauranteResponseDto toResponse(RestauranteModel restauranteModel);

    List<RestauranteResponseDto> toResponseList(List<RestauranteModel> restauranteModelList);
}
