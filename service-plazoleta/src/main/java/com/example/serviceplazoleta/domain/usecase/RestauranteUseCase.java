package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.domain.api.IRestauranteServicePort;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.exception.CampoInvalidoExcepcion;
import com.example.serviceplazoleta.infraestructure.exception.NoExisteElPropietario;
import com.example.serviceplazoleta.infraestructure.exception.NotRolException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;

import java.util.List;

public class RestauranteUseCase implements IRestauranteServicePort {

    private final IRestaurantePersistencePort restaurantePersistencePort;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    private final IUserFeign iUserFeign;

    public RestauranteUseCase(IRestaurantePersistencePort restaurantePersistencePort, IRestauranteEntityMapper restauranteEntityMapper, IUserFeign iUserFeign) {
        this.restaurantePersistencePort = restaurantePersistencePort;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.iUserFeign = iUserFeign;
    }

    @Override
    public RestauranteModel guardarRestaurante(RestauranteModel restauranteModel) {
        UserResponseDto userResponseDto;
        try {
            userResponseDto=iUserFeign.obtenerIdUser(restauranteModel.getIdPropietario());
        }catch(Exception exception) {
            throw new RuntimeException();
        }
        if (!userResponseDto.getRol().getNombre().equals("PROPIETARIO") ){
            throw new NoExisteElPropietario("No existe el Propietario ingresado");
        }
        if (!restauranteModel.numeroTelefonoValido()){
            throw new CampoInvalidoExcepcion("El nuemero de "+restauranteModel.getTelefono()+" no es invalido");
        }
        if (!restauranteModel.validarNombre()){
            throw new CampoInvalidoExcepcion("El nombre "+restauranteModel.getNombre()+" no es invalido");
        }
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
