package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import com.example.serviceplazoleta.domain.api.IRestauranteServicePort;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;

import java.util.List;

public class RestauranteUseCase implements IRestauranteServicePort {

    private final IRestaurantePersistencePort restaurantePersistencePort;

    public RestauranteUseCase(IRestaurantePersistencePort restaurantePersistencePort) {
        this.restaurantePersistencePort = restaurantePersistencePort;
    }

    @Override
    public void guardarRestaurante(RestauranteModel restauranteModel) {
         restaurantePersistencePort.guardarRestaurante(restauranteModel);
    }

    @Override
    public List<RestauranteModel> listarRestaurantes() {
        return restaurantePersistencePort.listarRestaurantes();
    }

//    @Override
//    public RestauranteResponseDto ObtenerRestauranteId(Long idRest) {
//        return restaurantePersistencePort.ObtenerRestauranteId(idRest);
//    }
}
