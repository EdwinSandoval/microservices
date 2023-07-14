package com.example.serviceplazoleta.domain.usecase;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RestauranteUseCaseTest {
    @Mock
    private IRestaurantePersistencePort restaurantePersistencePort;

    @InjectMocks
    private RestauranteUseCase restauranteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarRestaurante_DeberiaDevolverRestauranteModel() {
        // Arrange
        RestauranteModel inputModel = new RestauranteModel();
        RestauranteModel expectedModel = new RestauranteModel();
        when(restaurantePersistencePort.guardarRestaurante(inputModel)).thenReturn(expectedModel);

        // Act
        RestauranteModel result = restauranteUseCase.guardarRestaurante(inputModel);

        // Assert
        assertNotNull(result);
        assertEquals(expectedModel, result);
        verify(restaurantePersistencePort, times(1)).guardarRestaurante(inputModel);
    }

    @Test
    void listarRestaurantes_DeberiaDevolverListaNoVacia() {
        // Arrange
        List<RestauranteModel> expectedModelList = new ArrayList<>();
        expectedModelList.add(new RestauranteModel());
        when(restaurantePersistencePort.listarRestaurantes()).thenReturn(expectedModelList);

        // Act
        List<RestauranteModel> result = restauranteUseCase.listarRestaurantes();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedModelList, result);
        verify(restaurantePersistencePort, times(1)).listarRestaurantes();
    }

    @Test
    void obtenerRestauranteId_DeberiaDevolverRestauranteModel() {
        // Arrange
        Long idRestaurante = 1L;
        RestauranteModel expectedModel = new RestauranteModel();
        when(restaurantePersistencePort.obtenerRestauranteId(idRestaurante)).thenReturn(expectedModel);

        // Act
        RestauranteModel result = restauranteUseCase.obtenerRestauranteId(idRestaurante);

        // Assert
        assertNotNull(result);
        assertEquals(expectedModel, result);
        verify(restaurantePersistencePort, times(1)).obtenerRestauranteId(idRestaurante);
    }
}