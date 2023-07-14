package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.PedidoRequestDto;
import com.example.serviceplazoleta.application.dto.response.PedidoResponseDto;
import com.example.serviceplazoleta.application.mapper.IPedidoRequestMapper;
import com.example.serviceplazoleta.application.mapper.IPedidoResponseMapper;
import com.example.serviceplazoleta.domain.api.IPedidoServicePort;
import com.example.serviceplazoleta.domain.model.PedidoModel;
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

class PedidoHandlerTest {
    @Mock
    private IPedidoServicePort pedidoServicePort;

    @Mock
    private IPedidoRequestMapper pedidoRequestMapper;

    @Mock
    private IPedidoResponseMapper pedidoResponseMapper;

    @InjectMocks
    private PedidoHandler pedidoHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPedido_DeberiaLlamarMetodoGuardarPedidoEnServicePort() {
        // Arrange
        PedidoRequestDto pedidoRequestDto = new PedidoRequestDto();
        PedidoModel pedidoModel = new PedidoModel();

        when(pedidoRequestMapper.toPedido(pedidoRequestDto)).thenReturn(pedidoModel);

        // Act
        pedidoHandler.guardarPedido(pedidoRequestDto);

        // Assert
        verify(pedidoRequestMapper, times(1)).toPedido(pedidoRequestDto);
        verify(pedidoServicePort, times(1)).guardarPedido(pedidoModel);
    }

    @Test
    void listarPedidos_DeberiaDevolverListaPedidoResponseDto() {
        // Arrange
        List<PedidoModel> pedidoModelList = new ArrayList<>();
        pedidoModelList.add(new PedidoModel());

        List<PedidoResponseDto> expectedResponseDtoList = new ArrayList<>();
        expectedResponseDtoList.add(new PedidoResponseDto());

        when(pedidoServicePort.listarPedidos()).thenReturn(pedidoModelList);
        when(pedidoResponseMapper.toResponseList(pedidoModelList)).thenReturn(expectedResponseDtoList);

        // Act
        List<PedidoResponseDto> responseList = pedidoHandler.listarPedidos();

        // Assert
        assertEquals(expectedResponseDtoList, responseList);
        verify(pedidoServicePort, times(1)).listarPedidos();
        verify(pedidoResponseMapper, times(1)).toResponseList(pedidoModelList);
    }
}