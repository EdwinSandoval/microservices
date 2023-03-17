package com.example.serviceplazoleta.application.mapper;

import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IPlatoRequestMapper {
    PlatoModel toPlato(PlatoRequestDto platoRequestDto);
}
