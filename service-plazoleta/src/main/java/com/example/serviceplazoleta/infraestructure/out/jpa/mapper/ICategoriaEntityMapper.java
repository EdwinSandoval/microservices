package com.example.serviceplazoleta.infraestructure.out.jpa.mapper;

import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICategoriaEntityMapper {

    CategoriaEntity toEntity(CategoriaModel categoriaModel);
    CategoriaModel toCategoriaModel(CategoriaEntity categoriaEntity);
    List<CategoriaModel> toCategoriaModelList(List<CategoriaEntity> categoriaEntityList);

}
