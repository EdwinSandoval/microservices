package com.pragma.usuarioservice.application.mapper;

import com.pragma.usuarioservice.application.dto.request.UserRequestDto;
import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    UsuarioModel toUser(UserRequestDto userRequestDto);

//    @Mapping(target="nombre",source="userRequestDto.rol.nombre")
//    @Mapping(target="descripcion",source="userRequestDto.rol.descripcion")
//    RolModel toRol(UserRequestDto userRequestDto);
}
