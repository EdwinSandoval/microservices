package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.domain.api.IRestauranteServicePort;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class RestauranteUseCase implements IRestauranteServicePort {

    private final IRestaurantePersistencePort restaurantePersistencePort;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    public RestauranteUseCase(IRestaurantePersistencePort restaurantePersistencePort, IRestauranteEntityMapper restauranteEntityMapper) {
        this.restaurantePersistencePort = restaurantePersistencePort;
        this.restauranteEntityMapper = restauranteEntityMapper;
    }

    @Override
    public RestauranteModel guardarRestaurante(RestauranteModel restauranteModel) {
        RestauranteEntity restauranteEntity=restauranteEntityMapper.toEntity(restauranteModel);
         return restaurantePersistencePort.guardarRestaurante(restauranteModel);
    }

    @Override
    public List<RestauranteModel> listarRestaurantes() {
        return restaurantePersistencePort.listarRestaurantes();
    }

    @Override
    public List<RestauranteModel> listarRestaurantesPaginados(Integer numeroPaginas, Integer elementoPorPagina) {
        return restaurantePersistencePort.listarRestaurantesPaginados(numeroPaginas, elementoPorPagina);
    }

    @Override
    public RestauranteModel obtenerRestauranteId(Long idRest) {
        return restaurantePersistencePort.obtenerRestauranteId(idRest);
//        return platoPersistencePort.buscarPlatoId(idPlato);
    }
}
