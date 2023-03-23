package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.dto.response.Restaurante.ObtenerRestauranteIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.spi.IPlatoPersistencePort;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.exception.NotRolException;
import com.example.serviceplazoleta.infraestructure.exception.PlatoValidarException;
import com.example.serviceplazoleta.infraestructure.exceptionhandler.ControllerAdvisor;
import com.example.serviceplazoleta.infraestructure.input.rest.RestauranteRestController;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PlatoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPlatoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPlatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class PlatoJpaAdapter implements IPlatoPersistencePort {

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;

    private final IUserFeign iUserFeign;
    @Autowired
    private RestauranteRestController restauranteRestController;
    @Override
    public PlatoModel guardarPlato(PlatoModel platoModel) {
//        RestauranteRestController restauranteRestController;
        UserResponseDto userResponseDto;
        ObtenerRestauranteIdResponseDto idRest=restauranteRestController.obtenerRestauranteId(platoModel.getRestaurant().getId());//obtengo el id del restaurante
        System.out.println("dddddddddddddddddddd"+idRest);
        userResponseDto=iUserFeign.obtenerId(idRest.getIdPropietario());
        System.out.println("dddddddddddddddddddd"+userResponseDto);
//        System.out.println("holaaaaaaaaaa222222222"+userResponseDto);
        if (!userResponseDto.getRol().getNombre().equals("propietario")){
            throw new NotRolException("No cuenta con rol propietario");
        }

//        if (!platoModel.precioMayorCero()) {
//            throw new NotRolException("Ingrese precio mayor a cero");
//        }

        PlatoEntity platoEntity = platoRepository.save(platoEntityMapper.toEntity(platoModel));
        return platoEntityMapper.toPlatoModel(platoEntity);


//        try {
//            userResponseDto=iUserFeign.obtenerId(restauranteModel.getIdPropietario());
//        }catch(Exception exception) {
//            throw new RuntimeException();
//        }
//        if (!userResponseDto.getRol().getNombre().equals("administrador")){
//            throw new NotRolException("No cuenta con rol admin");
//        }
//        RestauranteEntity restauranteEntity = restauranteRepository
//                .save(restauranteEntityMapper.toEntity(restauranteModel));
//        return restauranteEntityMapper.toRestauranteModel(restauranteEntity);
    }

    @Override
    public List<PlatoModel> listarPlatos() {
        List<PlatoEntity> entityList = platoRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return platoEntityMapper.toPlatoModelList(entityList);
    }

    @Override
    public void actualizarPlato(PlatoModel platoModel) {

        platoRepository.save(platoEntityMapper.toEntity(platoModel));
    }

    @Override
    public PlatoModel buscarPlatoId(Long idPlato) {
        return platoEntityMapper.toPlatoModel(platoRepository.findById(idPlato)
                .orElseThrow(NoDataFoundException::new));
    }
}
