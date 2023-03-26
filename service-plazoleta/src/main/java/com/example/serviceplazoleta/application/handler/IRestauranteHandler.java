package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.response.Restaurante.ObtenerRestauranteIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;

import java.util.List;

public interface IRestauranteHandler {

    void guardarRestaurante(RestauranteRequestDto restauranteRequestDto);

    List<RestauranteResponseDto> listarRestaurantes();

    ObtenerRestauranteIdResponseDto obtenerRestauranteId(Long idRest);
}
