package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.dto.response.Restaurante.ObtenerRestauranteIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.spi.IPlatoPersistencePort;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.exception.NotRolException;
import com.example.serviceplazoleta.infraestructure.exception.PlatoValidarException;
import com.example.serviceplazoleta.infraestructure.exceptionhandler.ControllerAdvisor;
import com.example.serviceplazoleta.infraestructure.input.rest.RestauranteRestController;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.CategoriaEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PlatoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPlatoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.ICategoriaRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPlatoRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PlatoJpaAdapter implements IPlatoPersistencePort {

    private final IPlatoRepository platoRepository;
    private final ICategoriaRepository categoriaRepository;
    private final IRestauranteRepository restauranteRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    private final ICategoriaEntityMapper categoriaEntityMapper;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    private final IUserFeign iUserFeign;
//    @Autowired
//    private RestauranteRestController restauranteRestController;
    @Override
    public PlatoModel guardarPlato(PlatoModel platoModel) {

        PlatoEntity platoEntity=platoEntityMapper.toEntity(platoModel);
        CategoriaEntity existeCategoria = categoriaRepository.findByIdCategoria(platoModel.getCategoria().getIdCategoria());
        RestauranteEntity existeRest = restauranteRepository.findByIdRestaurante(platoModel.getRestaurant().getIdRestaurante());

        if (existeCategoria!=null && existeRest!=null) {
            platoEntity.setCategoria(categoriaRepository.findByIdCategoria(platoModel.getCategoria().getIdCategoria()));
            platoEntity.setRestaurant(restauranteRepository.findByIdRestaurante(platoModel.getRestaurant().getIdRestaurante()));
            return platoEntityMapper.toPlatoModel(platoRepository.save(platoEntity));

        }

        throw new NoDataFoundException();
//        PlatoEntity platoEntity = platoRepository.save(platoEntityMapper.toEntity(platoModel));

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
