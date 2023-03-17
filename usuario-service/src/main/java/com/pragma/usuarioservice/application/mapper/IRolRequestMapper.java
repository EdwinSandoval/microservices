package com.pragma.usuarioservice.application.mapper;

import com.pragma.usuarioservice.application.dto.request.RolRequestDto;
import com.pragma.usuarioservice.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolRequestMapper {
    RolModel toRol(RolRequestDto rolRequestDto);
}
