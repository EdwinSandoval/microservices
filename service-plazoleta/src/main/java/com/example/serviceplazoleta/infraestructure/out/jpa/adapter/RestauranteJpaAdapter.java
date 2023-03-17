package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.request.UserRestaurante.UserRestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.application.dto.response.UserRestaurantResponseDto;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RestauranteJpaAdapter implements IRestaurantePersistencePort {

    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;
    private final RestTemplate restTemplate;

    //    @Override
//    public RestauranteModel guardarRestaurante(RestauranteModel restauranteModel) {
//        RestauranteEntity restauranteEntity = restauranteRepository
//                .save(restauranteEntityMapper.toEntity(restauranteModel));
//        return restauranteEntityMapper.toRestauranteModel(restauranteEntity);
//    }
    @Override
    public RestauranteModel guardarRestaurante(RestauranteModel restauranteModel) {

    RestauranteEntity restauranteEntity = restauranteRepository
            .save(restauranteEntityMapper.toEntity(restauranteModel));
   return restauranteEntityMapper.toRestauranteModel(restauranteEntity);

    }


    @Override
    public List<RestauranteModel> listarRestaurantes() {
        List<RestauranteEntity> entityList = restauranteRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restauranteEntityMapper.toRestauranteModelList(entityList);
    }

    @Override
    public RestauranteResponseDto ObtenerRestauranteId(Long idRest) {
        RestauranteResponseDto restauranteResponseDto= new RestauranteResponseDto();
        RestauranteEntity restaurante=new RestauranteEntity();
        restaurante=restauranteRepository.findById(idRest).get();
        ResponseEntity<UserResponseDto> responseEntity=restTemplate.getForEntity(
                "http://localhost:8081/api/v1/user/listar/"+restaurante.getIdPropietario(),
                UserResponseDto.class);

        UserResponseDto userResponseDto=responseEntity.getBody();
        restauranteResponseDto.setRestauranteModel(restauranteEntityMapper.toRestauranteModel(restaurante));
        restauranteResponseDto.setUserResponseDto(userResponseDto);

        return restauranteResponseDto;
    }


}
