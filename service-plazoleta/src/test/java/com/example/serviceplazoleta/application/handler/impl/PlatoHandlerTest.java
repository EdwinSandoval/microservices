package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.mapper.IPlatoRequestMapper;
import com.example.serviceplazoleta.application.mapper.IPlatoResponseMapper;
import com.example.serviceplazoleta.domain.api.IPlatoServicePort;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class PlatoHandlerTest {
    @Mock
    private IPlatoServicePort platoServicePort;

    @Mock
    private IPlatoRequestMapper platoRequestMapper;

    @Mock
    private IPlatoResponseMapper platoResponseMapper;

    @InjectMocks
    private PlatoHandler platoHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPlato_DeberiaDevolverPlatoResponseDto() {
        // Arrange
        PlatoRequestDto platoRequestDto = new PlatoRequestDto();
        PlatoModel platoModel = new PlatoModel();
        PlatoResponseDto expectedResponseDto = new PlatoResponseDto();

        when(platoRequestMapper.toPlato(platoRequestDto)).thenReturn(platoModel);
        when(platoServicePort.guardarPlato(platoModel)).thenReturn(platoModel);
        when(platoResponseMapper.toResponse(platoModel)).thenReturn(expectedResponseDto);

        // Act
        PlatoResponseDto response = platoHandler.guardarPlato(platoRequestDto);

        // Assert
        assertEquals(expectedResponseDto, response);
        verify(platoRequestMapper, times(1)).toPlato(platoRequestDto);
        verify(platoServicePort, times(1)).guardarPlato(platoModel);
        verify(platoResponseMapper, times(1)).toResponse(platoModel);
    }

    @Test
    void listarPlatos_DeberiaDevolverListaPlatoResponseDto() {
        // Arrange
        List<PlatoModel> platoModelList = new ArrayList<>();
        platoModelList.add(new PlatoModel());

        List<PlatoResponseDto> expectedResponseDtoList = new ArrayList<>();
        expectedResponseDtoList.add(new PlatoResponseDto());

        when(platoServicePort.listarPlatos()).thenReturn(platoModelList);
        when(platoResponseMapper.toResponseList(platoModelList)).thenReturn(expectedResponseDtoList);

        // Act
        List<PlatoResponseDto> responseList = platoHandler.listarPlatos();

        // Assert
        assertEquals(expectedResponseDtoList, responseList);
        verify(platoServicePort, times(1)).listarPlatos();
        verify(platoResponseMapper, times(1)).toResponseList(platoModelList);
    }

    @Test
    void actualizarPlato_DeberiaActualizarPlatoSiExiste() {
        // Arrange
        ActualizarPlatoRequest actualizarPlatoRequest = new ActualizarPlatoRequest();
        actualizarPlatoRequest.setId(1L);
        actualizarPlatoRequest.setDescripcion("Este es un plato delioso");
        actualizarPlatoRequest.setPrecio(1);

        PlatoModel platoAntiguo = new PlatoModel();
        platoAntiguo.setId(1L);
        platoAntiguo.setNombre("Plato de ejemplo");
        platoAntiguo.setDescripcion("Este es un plato delicioso");
        platoAntiguo.setPrecio(10);
        platoAntiguo.setUrlImagen("https://ejemplo.com/imagen.jpg");
        platoAntiguo.setActivo(true);
        platoAntiguo.setCategoria(new CategoriaModel());
        platoAntiguo. setRestaurant(new RestauranteModel());
        PlatoModel platoModel = new PlatoModel();

//        platoModel.setId(1L);
//        platoModel.setNombre("Plato de ejemplo");
//        platoModel.setDescripcion("Este es un plato delicioso");
//        platoModel.setPrecio(10);
//        platoModel.setUrlImagen("https://ejemplo.com/imagen.jpg");
//        platoModel.setActivo(true);
//        platoModel.setCategoria(new CategoriaModel());
//        platoModel. setRestaurant(new RestauranteModel());
        when(platoServicePort.buscarPlatoId(actualizarPlatoRequest.getId())).thenReturn(platoAntiguo);
        doNothing().when(platoServicePort).actualizarPlato(platoModel);

        // Act
        platoHandler.actualizarPlato(actualizarPlatoRequest);

        // Assert
        verify(platoServicePort, times(1)).buscarPlatoId(actualizarPlatoRequest.getId());
        verify(platoServicePort, times(1)).actualizarPlato(platoModel);
    }

    @Test
    void actualizarPlato_NoDeberiaActualizarElPlatoSiNoExiste() {
        // Arrange
        ActualizarPlatoRequest actualizarPlatoRequest = new ActualizarPlatoRequest();
        PlatoModel platoAntiguo = null;

        when(platoServicePort.buscarPlatoId(actualizarPlatoRequest.getId())).thenReturn(platoAntiguo);

        // Act
        platoHandler.actualizarPlato(actualizarPlatoRequest);

        // Assert
        verify(platoServicePort, times(1)).buscarPlatoId(actualizarPlatoRequest.getId());
        verify(platoServicePort, times(0)).actualizarPlato(any());
    }

    @Test
    void buscarPlatoId_DeberiaDevolverBuscarPlatoIdResponseDto() {
        // Arrange
        Long platoId = 1L;
        PlatoModel platoModel = new PlatoModel();
        BuscarPlatoIdResponseDto expectedResponseDto = new BuscarPlatoIdResponseDto();

        when(platoServicePort.buscarPlatoId(platoId)).thenReturn(platoModel);
        when(platoResponseMapper.toResponseId(platoModel)).thenReturn(expectedResponseDto);

        // Act
        BuscarPlatoIdResponseDto response = platoHandler.buscarPlatoId(platoId);

        // Assert
        assertEquals(expectedResponseDto, response);
        verify(platoServicePort, times(1)).buscarPlatoId(platoId);
        verify(platoResponseMapper, times(1)).toResponseId(platoModel);
    }

}