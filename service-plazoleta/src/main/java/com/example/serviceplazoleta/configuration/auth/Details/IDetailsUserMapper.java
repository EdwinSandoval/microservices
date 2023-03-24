package com.example.serviceplazoleta.configuration.auth.Details;


import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.configuration.auth.UserAuthDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDetailsUserMapper {
    @Mapping(source = "userResponseDto.rol.nombre", target = "rol")
    DetailsUser toUser(UserResponseDto userResponseDto);
    UserAuthDto toUserAuth(DetailsUser user);
}
