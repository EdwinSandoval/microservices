package com.example.serviceplazoleta.domain.spi;

import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import com.example.serviceplazoleta.domain.model.RestauranteModel;

import java.util.List;

public interface IRestaurantePersistencePort {


    RestauranteModel guardarRestaurante(RestauranteModel restauranteModel);

    List<RestauranteModel> listarRestaurantes();

    RestauranteModel obtenerRestauranteId(Long idRest);
    List<RestauranteModel> listarRestaurantesPaginados(Integer numeroPaginas,
                                                      Integer elementoPorPagina);

//    RestauranteResponseDto ObtenerRestauranteId(Long idRest);
}

