package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.handler.IPlatoHandler;
import com.example.serviceplazoleta.application.mapper.IPlatoRequestMapper;
import com.example.serviceplazoleta.application.mapper.IPlatoResponseMapper;
import com.example.serviceplazoleta.domain.api.IPlatoServicePort;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor//automaticamnete genera constructor a lo que hallamos definido como final
@Service//toma la clase como un bean y ya se puede inyectar
@Transactional
public class PlatoHandler  implements IPlatoHandler {

    private final IPlatoServicePort platoServicePort;
    private final IPlatoRequestMapper platoRequestMapper;
    private final IPlatoResponseMapper platoResponseMapper;

    @Override
    public void guardarPlato(PlatoRequestDto platoRequestDto) {
        PlatoModel platoModel = platoRequestMapper.toPlato(platoRequestDto);
        platoServicePort.guardarPlato(platoModel);
    }

    @Override
    public List<PlatoResponseDto> listarPlatos() {
        return platoResponseMapper.toResponseList(platoServicePort.listarPlatos());
    }
}
