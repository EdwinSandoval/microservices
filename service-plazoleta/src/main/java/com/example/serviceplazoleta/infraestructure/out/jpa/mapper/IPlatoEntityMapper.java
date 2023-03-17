package com.example.serviceplazoleta.infraestructure.out.jpa.mapper;

import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PlatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPlatoEntityMapper {

    PlatoEntity toEntity(PlatoModel platoModel);
    PlatoModel toPlatoModel(PlatoEntity platoEntity);
    List<PlatoModel> toPlatoModelList(List<PlatoEntity> platoEntityList);
}
