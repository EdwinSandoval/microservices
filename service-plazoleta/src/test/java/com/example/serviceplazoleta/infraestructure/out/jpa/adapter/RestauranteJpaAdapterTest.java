package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IRestauranteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class RestauranteJpaAdapterTest {

    @Mock
    private  IRestauranteRepository restauranteRepository;
    @Mock
    private  IRestauranteEntityMapper restauranteEntityMapper;

    @InjectMocks
    private RestauranteJpaAdapter restauranteJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        restauranteJpaAdapter=new RestauranteJpaAdapter(restauranteRepository,restauranteEntityMapper);
    }

    @Test
    void guardarRestaurante() {
//        RestauranteModel restauranteModel=new RestauranteModel();
//        restauranteJpaAdapter.guardarRestaurante(restauranteModel);
//        verify(restauranteRepository,times(1)).save(restauranteEntityMapper.toEntity(restauranteModel));
        RestauranteModel inputModel = new RestauranteModel();
        RestauranteEntity savedEntity = new RestauranteEntity();
        when(restauranteRepository.save(any())).thenReturn(savedEntity);
        when(restauranteEntityMapper.toRestauranteModel(savedEntity)).thenReturn(inputModel);

        // Act
        RestauranteModel result = restauranteJpaAdapter.guardarRestaurante(inputModel);

        // Assert
        assertNotNull(result);
        assertEquals(inputModel, result);
        verify(restauranteRepository, times(1)).save(any());
        verify(restauranteEntityMapper, times(1)).toRestauranteModel(savedEntity);
    }

    @Test
    void listarRestaurantes() {
        List<RestauranteEntity> entityList = new ArrayList<>();
        entityList.add(new RestauranteEntity());
        when(restauranteRepository.findAll()).thenReturn(entityList);

        List<RestauranteModel> expectedModelList = new ArrayList<>();
        expectedModelList.add(new RestauranteModel());
        when(restauranteEntityMapper.toRestauranteModelList(entityList)).thenReturn(expectedModelList);

        // Act
        List<RestauranteModel> result = restauranteJpaAdapter.listarRestaurantes();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedModelList, result);
        verify(restauranteRepository, times(1)).findAll();
        verify(restauranteEntityMapper, times(1)).toRestauranteModelList(entityList);
    }

    @Test
    void listarRestaurantes_SinDatos_DeberiaLanzarExcepcion() {
        // Arrange
        when(restauranteRepository.findAll()).thenReturn(new ArrayList<>());

        // Act and Assert
        assertThrows(NoDataFoundException.class, () -> restauranteJpaAdapter.listarRestaurantes());
        verify(restauranteRepository, times(1)).findAll();
        verifyNoInteractions(restauranteEntityMapper);
    }

    @Test
    void obtenerRestauranteId() {
        Long idRestaurante = 1L;
        RestauranteEntity entity = new RestauranteEntity();
        RestauranteModel expectedModel = new RestauranteModel();
        when(restauranteRepository.findById(idRestaurante)).thenReturn(Optional.of(entity));
        when(restauranteEntityMapper.toRestauranteModel(entity)).thenReturn(expectedModel);

        // Act
        RestauranteModel result = restauranteJpaAdapter.obtenerRestauranteId(idRestaurante);

        // Assert
        assertNotNull(result);
        assertEquals(expectedModel, result);
        verify(restauranteRepository, times(1)).findById(idRestaurante);
        verify(restauranteEntityMapper, times(1)).toRestauranteModel(entity);
    }

    @Test
    void obtenerRestauranteId_IdNoExistente_DeberiaLanzarExcepcion() {
        // Arrange
        Long idRestaurante = 1L;
        when(restauranteRepository.findById(idRestaurante)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NoDataFoundException.class, () -> restauranteJpaAdapter.obtenerRestauranteId(idRestaurante));
        verify(restauranteRepository, times(1)).findById(idRestaurante);
        verifyNoInteractions(restauranteEntityMapper);
    }
}