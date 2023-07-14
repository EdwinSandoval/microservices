package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.PedidoModel;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PedidoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPedidoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class PedidoJpaAdapterTest {

    @Mock
    private IPedidoRepository pedidoRepository;

    @Mock
    private IPedidoEntityMapper pedidoEntityMapper;

    @InjectMocks
    private PedidoJpaAdapter pedidoJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPedido_DeberiaDevolverPedidoModel() {
        // Arrange
        PedidoModel inputModel = new PedidoModel();
        PedidoEntity savedEntity = new PedidoEntity();
        when(pedidoRepository.save(any())).thenReturn(savedEntity);
        when(pedidoEntityMapper.toPedidoModel(savedEntity)).thenReturn(inputModel);

        // Act
        PedidoModel result = pedidoJpaAdapter.guardarPedido(inputModel);

        // Assert
        assertNotNull(result);
        assertEquals(inputModel, result);
        verify(pedidoRepository, times(1)).save(any());
        verify(pedidoEntityMapper, times(1)).toPedidoModel(savedEntity);
    }

    @Test
    void listarPedidos_DeberiaDevolverListaNoVacia() {
        // Arrange
        List<PedidoEntity> entityList = new ArrayList<>();
        entityList.add(new PedidoEntity());
        when(pedidoRepository.findAll()).thenReturn(entityList);

        List<PedidoModel> expectedModelList = new ArrayList<>();
        expectedModelList.add(new PedidoModel());
        when(pedidoEntityMapper.toPedidoModelList(entityList)).thenReturn(expectedModelList);

        // Act
        List<PedidoModel> result = pedidoJpaAdapter.listarPedidos();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedModelList, result);
        verify(pedidoRepository, times(1)).findAll();
        verify(pedidoEntityMapper, times(1)).toPedidoModelList(entityList);
    }

    @Test
    void listarPedidos_SinDatos_DeberiaLanzarExcepcion() {
        // Arrange
        when(pedidoRepository.findAll()).thenReturn(new ArrayList<>());

        // Act and Assert
        assertThrows(NoDataFoundException.class, () -> pedidoJpaAdapter.listarPedidos());
        verify(pedidoRepository, times(1)).findAll();
        verifyNoInteractions(pedidoEntityMapper);
    }
}