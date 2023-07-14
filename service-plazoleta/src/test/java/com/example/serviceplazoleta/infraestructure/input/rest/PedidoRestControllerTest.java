package com.example.serviceplazoleta.infraestructure.input.rest;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceplazoleta.application.dto.request.PedidoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PedidoResponseDto;
import com.example.serviceplazoleta.application.handler.IPedidoHandler;
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
class PedidoRestControllerTest {
    @Mock
    private IPedidoHandler pedidoHandler;

    @InjectMocks
    private PedidoRestController pedidoRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPedido_DeberiaDevolverResponseEntityConHttpStatusCreated() {
        // Arrange
        PedidoRequestDto pedidoRequestDto = new PedidoRequestDto();

        // Act
        ResponseEntity<Void> response = pedidoRestController.guardarPedido(pedidoRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(pedidoHandler, times(1)).guardarPedido(pedidoRequestDto);
    }

    @Test
    void listarPedidos_DeberiaDevolverResponseEntityConListaPedidoResponseDtoYHttpStatusOk() {
        // Arrange
        List<PedidoResponseDto> expectedResponseDtoList = new ArrayList<>();
        expectedResponseDtoList.add(new PedidoResponseDto());
        when(pedidoHandler.listarPedidos()).thenReturn(expectedResponseDtoList);

        // Act
        ResponseEntity<List<PedidoResponseDto>> response = pedidoRestController.listarPedidos();

        // Assert
        assertEquals(expectedResponseDtoList, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(pedidoHandler, times(1)).listarPedidos();
    }
}