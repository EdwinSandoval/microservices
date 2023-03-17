package com.pragma.usuarioservice.application.mapper;

import com.pragma.usuarioservice.application.dto.response.UserResponseDto;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
       )

public interface IUserResponseMapper {


    UserResponseDto toResponse(UsuarioModel usuarioModel);

    List<UserResponseDto> toResponseList(List<UsuarioModel> usuarioModelList);
//    IRolDtoMapper INSTANCE= Mappers.getMapper(IRolDtoMapper.class);
//    @Mapping(target = "rol.nombre",source = "rolDto.nombre")
//    @Mapping(target = "rol.descripcion",source = "rolDto.descripcion")
//    UserResponseDto toResponse(UsuarioModel usuarioModel, RolDto rolDto);
//
////    List<UserResponseDto> toResponseList(List<UsuarioModel> usuarioModelList);
//
//    default  List<UserResponseDto> toResponseList(List<UsuarioModel> usuarioModelList,
//                                                  List<RolModel> rolModelList){
//        return usuarioModelList.stream()
//                .map(user->{
//                    UserResponseDto userResponseDto=new UserResponseDto();
//                    userResponseDto.setId(user.getId());
//                    userResponseDto.setNombre(user.getNombre());
//                    userResponseDto.setApellido(user.getApellido());
//                    userResponseDto.setCelular(user.getCelular());
//                    userResponseDto.setCorreo(user.getCorreo());
//                    userResponseDto.setClave(user.getClave());
//                    userResponseDto.setRol(INSTANCE.toDto(rolModelList.stream()
//                            .filter(rol -> rol.getId().equals(user.getRolId()))
//                            .findFirst().orElse(null)));
//
//                    return userResponseDto;
//                }).collect(Collectors.toList());
//    }

}
