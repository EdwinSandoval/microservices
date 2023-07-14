package com.example.serviceplazoleta.infraestructure.input.rest;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.handler.IPlatoHandler;
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
class PlatoRestControllerTest {
    @Mock
    private IPlatoHandler platoHandler;

    @InjectMocks
    private PlatoRestController platoRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPlato_DeberiaDevolverResponseEntityConHttpStatusCreated() {
        // Arrange
        PlatoRequestDto platoRequestDto = new PlatoRequestDto();

        // Act
        ResponseEntity<Void> response = platoRestController.guardarPlato(platoRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(platoHandler, times(1)).guardarPlato(platoRequestDto);
    }

    @Test
    void listarPlatos_DeberiaDevolverResponseEntityConListaPlatoResponseDtoYHttpStatusOk() {
        // Arrange
        List<PlatoResponseDto> expectedResponseDtoList = new ArrayList<>();
        expectedResponseDtoList.add(new PlatoResponseDto());
        when(platoHandler.listarPlatos()).thenReturn(expectedResponseDtoList);

        // Act
        ResponseEntity<List<PlatoResponseDto>> response = platoRestController.listarPlatos();

        // Assert
        assertEquals(expectedResponseDtoList, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(platoHandler, times(1)).listarPlatos();
    }

    @Test
    void buscarPlatoId_DeberiaDevolverResponseEntityConBuscarPlatoIdResponseDtoYHttpStatusOk() {
        // Arrange
        Long platoId = 1L;
        BuscarPlatoIdResponseDto expectedResponseDto = new BuscarPlatoIdResponseDto();
        when(platoHandler.buscarPlatoId(platoId)).thenReturn(expectedResponseDto);

        // Act
        ResponseEntity<BuscarPlatoIdResponseDto> response = platoRestController.buscarPlatoId(platoId);

        // Assert
        assertEquals(expectedResponseDto, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(platoHandler, times(1)).buscarPlatoId(platoId);
    }

    @Test
    void actualizarPlato_DeberiaDevolverResponseEntityConHttpStatusAccepted() {
        // Arrange
        ActualizarPlatoRequest actualizarPlatoRequest = new ActualizarPlatoRequest();

        // Act
        ResponseEntity<Void> response = platoRestController.actualizarPlato(actualizarPlatoRequest);

        // Assert
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        verify(platoHandler, times(1)).actualizarPlato(actualizarPlatoRequest);
    }
}