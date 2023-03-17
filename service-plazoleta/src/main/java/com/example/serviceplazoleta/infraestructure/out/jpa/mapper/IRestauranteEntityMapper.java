package com.example.serviceplazoleta.infraestructure.out.jpa.mapper;

import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IRestauranteEntityMapper {

    RestauranteEntity toEntity(RestauranteModel restauranteModel);
    RestauranteModel toRestauranteModel(RestauranteEntity restauranteEntity);
    List<RestauranteModel> toRestauranteModelList(List<RestauranteEntity> restauranteEntityList);
}
