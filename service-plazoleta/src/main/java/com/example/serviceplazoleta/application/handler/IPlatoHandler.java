package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;

import java.util.List;

public interface IPlatoHandler {

    void guardarPlato(PlatoRequestDto platoRequestDto);

    List<PlatoResponseDto> listarPlatos();
}
