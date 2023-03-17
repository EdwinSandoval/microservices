package com.pragma.usuarioservice.infraestructure.out.jpa.mapper;

import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {
    UserEntity toEntity(UsuarioModel user);
    UsuarioModel toUserModel(UserEntity userEntity);
    List<UsuarioModel> toUserModelList(List<UserEntity> userEntityList);

}
