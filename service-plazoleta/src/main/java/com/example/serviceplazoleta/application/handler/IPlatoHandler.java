package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;

import java.util.List;

public interface IPlatoHandler {

    PlatoResponseDto guardarPlato(PlatoRequestDto platoRequestDto);

    List<PlatoResponseDto> listarPlatos();

    void actualizarPlato(ActualizarPlatoRequest actualizarPlatoRequest);

    BuscarPlatoIdResponseDto buscarPlatoId(Long idPlato);
}
