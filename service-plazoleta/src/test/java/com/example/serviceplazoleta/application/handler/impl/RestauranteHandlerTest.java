package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.RestauranteRequestDto;
import com.example.serviceplazoleta.application.dto.response.Restaurante.ObtenerRestauranteIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.RestauranteResponseDto;
import com.example.serviceplazoleta.application.mapper.IRestauranteRequestMapper;
import com.example.serviceplazoleta.application.mapper.IRestauranteResponseMapper;
import com.example.serviceplazoleta.domain.api.IRestauranteServicePort;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
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
import static org.junit.jupiter.api.Assertions.*;

class RestauranteHandlerTest {
    @Mock
    private IRestauranteServicePort restauranteServicePort;

    @Mock
    private IRestauranteRequestMapper restauranteRequestMapper;

    @Mock
    private IRestauranteResponseMapper restauranteResponseMapper;

    @InjectMocks
    private RestauranteHandler restauranteHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarRestaurante_DeberiaDevolverRestauranteResponseDto() {
        // Arrange
        RestauranteRequestDto restauranteRequestDto = new RestauranteRequestDto();
        RestauranteModel restauranteModel = new RestauranteModel();
        RestauranteResponseDto expectedResponseDto = new RestauranteResponseDto();

        when(restauranteRequestMapper.toRestaurante(restauranteRequestDto)).thenReturn(restauranteModel);
        when(restauranteServicePort.guardarRestaurante(restauranteModel)).thenReturn(restauranteModel);
        when(restauranteResponseMapper.toResponse(restauranteModel)).thenReturn(expectedResponseDto);

        // Act
        RestauranteResponseDto response = restauranteHandler.guardarRestaurante(restauranteRequestDto);

        // Assert
        assertEquals(expectedResponseDto, response);
        verify(restauranteRequestMapper, times(1)).toRestaurante(restauranteRequestDto);
        verify(restauranteServicePort, times(1)).guardarRestaurante(restauranteModel);
        verify(restauranteResponseMapper, times(1)).toResponse(restauranteModel);
    }

    @Test
    void listarRestaurantes_DeberiaDevolverListaRestauranteResponseDto() {
        // Arrange
        List<RestauranteModel> restauranteModelList = new ArrayList<>();
        restauranteModelList.add(new RestauranteModel());

        List<RestauranteResponseDto> expectedResponseDtoList = new ArrayList<>();
        expectedResponseDtoList.add(new RestauranteResponseDto());

        when(restauranteServicePort.listarRestaurantes()).thenReturn(restauranteModelList);
        when(restauranteResponseMapper.toResponseList(restauranteModelList)).thenReturn(expectedResponseDtoList);

        // Act
        List<RestauranteResponseDto> responseList = restauranteHandler.listarRestaurantes();

        // Assert
        assertEquals(expectedResponseDtoList, responseList);
        verify(restauranteServicePort, times(1)).listarRestaurantes();
        verify(restauranteResponseMapper, times(1)).toResponseList(restauranteModelList);
    }

    @Test
    void obtenerRestauranteId_DeberiaDevolverObtenerRestauranteIdResponseDto() {
        // Arrange
        Long restauranteId = 1L;
        RestauranteModel restauranteModel = new RestauranteModel();
        ObtenerRestauranteIdResponseDto expectedResponseDto = new ObtenerRestauranteIdResponseDto();

        when(restauranteServicePort.obtenerRestauranteId(restauranteId)).thenReturn(restauranteModel);
        when(restauranteResponseMapper.toResponseId(restauranteModel)).thenReturn(expectedResponseDto);

        // Act
        ObtenerRestauranteIdResponseDto response = restauranteHandler.obtenerRestauranteId(restauranteId);

        // Assert
        assertEquals(expectedResponseDto, response);
        verify(restauranteServicePort, times(1)).obtenerRestauranteId(restauranteId);
        verify(restauranteResponseMapper, times(1)).toResponseId(restauranteModel);
    }
}