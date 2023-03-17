package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import com.example.serviceplazoleta.domain.model.RestauranteModel;

import java.util.List;

public interface IRestauranteHandler {

    RestauranteResponseDto guardarRestaurante(RestauranteRequestDto restauranteRequestDto);

    List<RestauranteResponseDto> listarRestaurantes();

    RestauranteResponseDto ObtenerRestauranteId(Long idRest);
}
