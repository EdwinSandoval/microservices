package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlatoResponseMapper {
    PlatoResponseDto toResponse(PlatoModel platoModel);

    List<PlatoResponseDto> toResponseList(List<PlatoModel> platoModelList);
}
