package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.exception.NotRolException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IRestauranteRepository;
//import com.example.serviceplazoleta.infraestructure.out.jpa.repository.Usuario.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RestauranteJpaAdapter implements IRestaurantePersistencePort {

    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    private final IUserFeign iUserFeign;
//    private final RestTemplate restTemplate;

    @Override
    public RestauranteModel guardarRestaurante(RestauranteModel restauranteModel) {
            UserResponseDto userResponseDto;

                userResponseDto=iUserFeign.obtenerId(restauranteModel.getIdPropietario());

            if (!userResponseDto.getRol().getNombre().equals("propietario")){
                throw new NotRolException("No existe propietario");
            }
        RestauranteEntity restauranteEntity = restauranteRepository
                .save(restauranteEntityMapper.toEntity(restauranteModel));
        return restauranteEntityMapper.toRestauranteModel(restauranteEntity);
    }

    ////////////////////////////////////////
//    @Override
//    public RestauranteModel guardarRestaurante(RestauranteModel restauranteModel) {
//        if (restauranteRepository.findById(restauranteModel.getId()).isPresent()) {
//            throw new RestaurantExistsException("Existe restaurante");
//        }
//        return restauranteModel;
//    }
        ///////////////////////////////////

//        UserResponseDto userResponseDto=new UserResponseDto();
////        UserResponseDto userResponseDto= iUserRestaurante.guardarUsuario(new UserResponseDto(restauranteModel.getIdPropietario())).getBody();
//
//        restauranteModel.setIdPropietario(userResponseDto.getId());
//       return  restauranteRepository.save(restauranteModel);





    @Override
    public List<RestauranteModel> listarRestaurantes() {
        List<RestauranteEntity> entityList = restauranteRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restauranteEntityMapper.toRestauranteModelList(entityList);
    }

    @Override
    public RestauranteModel obtenerRestauranteId(Long idRest) {
        return restauranteEntityMapper.toRestauranteModel(restauranteRepository.findById(idRest)
                .orElseThrow(NoDataFoundException::new));
    }


}
