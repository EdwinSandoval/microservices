package com.example.serviceplazoleta.infraestructure.input.rest;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.response.Restaurante.ObtenerRestauranteIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import com.example.serviceplazoleta.application.handler.IRestauranteHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
class RestauranteRestControllerTest {
    @Mock
    private IRestauranteHandler restauranteHandler;

    @InjectMocks
    private RestauranteRestController restauranteRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarRestaurante_DeberiaDevolverResponseEntityConHttpStatusCreated() {
        // Arrange
        RestauranteRequestDto restauranteRequestDto = new RestauranteRequestDto();

        // Act
        ResponseEntity<Void> response = restauranteRestController.guardarRestaurante(restauranteRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(restauranteHandler, times(1)).guardarRestaurante(restauranteRequestDto);
    }

    @Test
    void listarRestaurantes_DeberiaDevolverResponseEntityConListaRestauranteResponseDtoYHttpStatusOk() {
        // Arrange
        List<RestauranteResponseDto> expectedResponseDtoList = new ArrayList<>();
        expectedResponseDtoList.add(new RestauranteResponseDto());
        when(restauranteHandler.listarRestaurantes()).thenReturn(expectedResponseDtoList);

        // Act
        ResponseEntity<List<RestauranteResponseDto>> response = restauranteRestController.listarRestaurantes();

        // Assert
        assertEquals(expectedResponseDtoList, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(restauranteHandler, times(1)).listarRestaurantes();
    }

    @Test
    void obtenerRestauranteId_DeberiaDevolverObtenerRestauranteIdResponseDto() {
        // Arrange
        Long restauranteId = 1L;
        ObtenerRestauranteIdResponseDto expectedResponseDto = new ObtenerRestauranteIdResponseDto();
        when(restauranteHandler.obtenerRestauranteId(restauranteId)).thenReturn(expectedResponseDto);

        // Act
        ObtenerRestauranteIdResponseDto response = restauranteRestController.obtenerRestauranteId(restauranteId);

        // Assert
        assertEquals(expectedResponseDto, response);
        verify(restauranteHandler, times(1)).obtenerRestauranteId(restauranteId);
    }
}