package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarEstadoPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.Plato.PlatoPaginadoResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.dto.response.Restaurante.ListarRestauranteResponseDto;

import java.util.List;

public interface IPlatoHandler {

    void guardarPlato(Long idProp,PlatoRequestDto platoRequestDto);

    List<PlatoResponseDto> listarPlatos();

    void actualizarPlato(ActualizarPlatoRequest actualizarPlatoRequest,Long idProp);
    void actualizarEstadoPlato(ActualizarEstadoPlatoRequest actualizarEstadoPlatoRequest,Long idProp);

    List<PlatoPaginadoResponseDto> listarPlatosPaginados(Long idRest,Integer numeroPaginas,
                                                               Integer elementoPorPagina);

    BuscarPlatoIdResponseDto buscarPlatoId(Long idPlato);
}
