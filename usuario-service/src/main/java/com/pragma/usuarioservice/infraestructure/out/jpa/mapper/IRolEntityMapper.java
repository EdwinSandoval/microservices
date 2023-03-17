package com.pragma.usuarioservice.infraestructure.out.jpa.mapper;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolEntityMapper {

    RolEntity toEntity(RolModel rol);
    RolModel toRolModel(RolEntity rolEntity);
    List<RolModel> toRolModelList(List<RolEntity> rolEntityList);
}
