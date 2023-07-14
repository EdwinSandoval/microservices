package com.example.serviceplazoleta.domain.usecase;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.spi.IPlatoPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
class PlatoUseCaseTest {
    @Mock
    private IPlatoPersistencePort platoPersistencePort;

    @InjectMocks
    private PlatoUseCase platoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPlato_DeberiaDevolverPlatoModel() {
        // Arrange
        PlatoModel inputModel = new PlatoModel();
        PlatoModel expectedModel = new PlatoModel();
        when(platoPersistencePort.guardarPlato(inputModel)).thenReturn(expectedModel);

        // Act
        PlatoModel result = platoUseCase.guardarPlato(inputModel);

        // Assert
        assertNotNull(result);
        assertEquals(expectedModel, result);
        verify(platoPersistencePort, times(1)).guardarPlato(inputModel);
    }

    @Test
    void listarPlatos_DeberiaDevolverListaNoVacia() {
        // Arrange
        List<PlatoModel> expectedModelList = new ArrayList<>();
        expectedModelList.add(new PlatoModel());
        when(platoPersistencePort.listarPlatos()).thenReturn(expectedModelList);

        // Act
        List<PlatoModel> result = platoUseCase.listarPlatos();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedModelList, result);
        verify(platoPersistencePort, times(1)).listarPlatos();
    }

    @Test
    void actualizarPlato_DeberiaLlamarMetodoActualizarPlato() {
        // Arrange
        PlatoModel platoModel = new PlatoModel();

        // Act
        platoUseCase.actualizarPlato(platoModel);

        // Assert
        verify(platoPersistencePort, times(1)).actualizarPlato(platoModel);
    }

    @Test
    void buscarPlatoId_DeberiaDevolverPlatoModel() {
        // Arrange
        Long idPlato = 1L;
        PlatoModel expectedModel = new PlatoModel();
        when(platoPersistencePort.buscarPlatoId(idPlato)).thenReturn(expectedModel);

        // Act
        PlatoModel result = platoUseCase.buscarPlatoId(idPlato);

        // Assert
        assertNotNull(result);
        assertEquals(expectedModel, result);
        verify(platoPersistencePort, times(1)).buscarPlatoId(idPlato);
    }
}