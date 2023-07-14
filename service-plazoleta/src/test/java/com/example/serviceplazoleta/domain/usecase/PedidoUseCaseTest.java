package com.example.serviceplazoleta.domain.usecase;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.domain.spi.IPedidoPersistencePort;
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

class PedidoUseCaseTest {
    @Mock
    private IPedidoPersistencePort pedidoPersistencePort;

    @InjectMocks
    private PedidoUseCase pedidoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPedido_DeberiaLlamarMetodoGuardarPedido() {
        // Arrange
        PedidoModel pedidoModel = new PedidoModel();

        // Act
        pedidoUseCase.guardarPedido(pedidoModel);

        // Assert
        verify(pedidoPersistencePort, times(1)).guardarPedido(pedidoModel);
    }

    @Test
    void listarPedidos_DeberiaDevolverListaNoVacia() {
        // Arrange
        List<PedidoModel> expectedModelList = new ArrayList<>();
        expectedModelList.add(new PedidoModel());
        when(pedidoPersistencePort.listarPedidos()).thenReturn(expectedModelList);

        // Act
        List<PedidoModel> result = pedidoUseCase.listarPedidos();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedModelList, result);
        verify(pedidoPersistencePort, times(1)).listarPedidos();
    }
}