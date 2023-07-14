package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PlatoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPlatoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPlatoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class PlatoJpaAdapterTest {
    @Mock
    private IPlatoRepository platoRepository;

    @Mock
    private IPlatoEntityMapper platoEntityMapper;

    @Mock
    private IUserFeign iUserFeign;

    @InjectMocks
    private PlatoJpaAdapter platoJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPlato() {
        PlatoModel inputModel = new PlatoModel();
        PlatoEntity savedEntity = new PlatoEntity();
        when(platoRepository.save(any())).thenReturn(savedEntity);
        when(platoEntityMapper.toPlatoModel(savedEntity)).thenReturn(inputModel);

        // Act
        PlatoModel result = platoJpaAdapter.guardarPlato(inputModel);

        // Assert
        assertNotNull(result);
        assertEquals(inputModel, result);
        verify(platoRepository, times(1)).save(any());
        verify(platoEntityMapper, times(1)).toPlatoModel(savedEntity);
    }

    @Test
    void listarPlatos() {
        List<PlatoEntity> entityList = new ArrayList<>();
        entityList.add(new PlatoEntity());
        when(platoRepository.findAll()).thenReturn(entityList);

        List<PlatoModel> expectedModelList = new ArrayList<>();
        expectedModelList.add(new PlatoModel());
        when(platoEntityMapper.toPlatoModelList(entityList)).thenReturn(expectedModelList);

        // Act
        List<PlatoModel> result = platoJpaAdapter.listarPlatos();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedModelList, result);
        verify(platoRepository, times(1)).findAll();
        verify(platoEntityMapper, times(1)).toPlatoModelList(entityList);
    }

    @Test
    void listarPlatos_SinDatos_DeberiaLanzarExcepcion() {
        // Arrange
        when(platoRepository.findAll()).thenReturn(new ArrayList<>());

        // Act and Assert
        assertThrows(NoDataFoundException.class, () -> platoJpaAdapter.listarPlatos());
        verify(platoRepository, times(1)).findAll();
        verifyNoInteractions(platoEntityMapper);
    }

    @Test
    void actualizarPlato() {
        PlatoModel platoModel = new PlatoModel();

        // Act and Assert
        assertDoesNotThrow(() -> platoJpaAdapter.actualizarPlato(platoModel));
        verify(platoRepository, times(1)).save(any());
        verify(platoEntityMapper, times(1)).toEntity(platoModel);
    }

    @Test
    void buscarPlatoId() {
        Long idPlato = 1L;
        PlatoEntity entity = new PlatoEntity();
        PlatoModel expectedModel = new PlatoModel();
        when(platoRepository.findById(idPlato)).thenReturn(Optional.of(entity));
        when(platoEntityMapper.toPlatoModel(entity)).thenReturn(expectedModel);

        // Act
        PlatoModel result = platoJpaAdapter.buscarPlatoId(idPlato);

        // Assert
        assertNotNull(result);
        assertEquals(expectedModel, result);
        verify(platoRepository, times(1)).findById(idPlato);
        verify(platoEntityMapper, times(1)).toPlatoModel(entity);
    }

    @Test
    void buscarPlatoId_IdNoExistente_DeberiaLanzarExcepcion() {
        // Arrange
        Long idPlato = 1L;
        when(platoRepository.findById(idPlato)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NoDataFoundException.class, () -> platoJpaAdapter.buscarPlatoId(idPlato));
        verify(platoRepository, times(1)).findById(idPlato);
        verifyNoInteractions(platoEntityMapper);
    }
}