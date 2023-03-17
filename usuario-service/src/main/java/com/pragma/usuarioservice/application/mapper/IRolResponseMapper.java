package com.pragma.usuarioservice.application.mapper;

import com.pragma.usuarioservice.application.dto.response.RolResponseDto;
import com.pragma.usuarioservice.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolResponseMapper {

    RolResponseDto toResponse(RolModel rolModel);

    List<RolResponseDto> toResponseList(List<RolModel> rolModelList);
}
