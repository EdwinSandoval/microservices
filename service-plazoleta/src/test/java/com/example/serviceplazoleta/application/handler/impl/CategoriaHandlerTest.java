package com.example.serviceplazoleta.application.handler.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceplazoleta.application.dto.request.CategoriaRequestDto;
import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import com.example.serviceplazoleta.application.mapper.ICategoriaRequestMapper;
import com.example.serviceplazoleta.application.mapper.ICategoriaResponseMapper;
import com.example.serviceplazoleta.domain.api.ICategoriaServicePort;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
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

class CategoriaHandlerTest {
    @Mock
    private ICategoriaServicePort categoriaServicePort;

    @Mock
    private ICategoriaRequestMapper categoriaRequestMapper;

    @Mock
    private ICategoriaResponseMapper categoriaResponseMapper;

    @InjectMocks
    private CategoriaHandler categoriaHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarCategoria_DeberiaDevolverCategoriaResponseDto() {
        // Arrange
        CategoriaRequestDto categoriaRequestDto = new CategoriaRequestDto();
        CategoriaModel categoriaModel = new CategoriaModel();
        CategoriaResponseDto expectedResponseDto = new CategoriaResponseDto();

        when(categoriaRequestMapper.toCategoria(categoriaRequestDto)).thenReturn(categoriaModel);
        when(categoriaServicePort.guardarCategoria(categoriaModel)).thenReturn(categoriaModel);
        when(categoriaResponseMapper.toResponse(categoriaModel)).thenReturn(expectedResponseDto);

        // Act
        CategoriaResponseDto response = categoriaHandler.guardarCategoria(categoriaRequestDto);

        // Assert
        assertEquals(expectedResponseDto, response);
        verify(categoriaRequestMapper, times(1)).toCategoria(categoriaRequestDto);
        verify(categoriaServicePort, times(1)).guardarCategoria(categoriaModel);
        verify(categoriaResponseMapper, times(1)).toResponse(categoriaModel);
    }

    @Test
    void listarCategorias_DeberiaDevolverListaCategoriaResponseDto() {
        // Arrange
        List<CategoriaModel> categoriaModelList = new ArrayList<>();
        categoriaModelList.add(new CategoriaModel());

        List<CategoriaResponseDto> expectedResponseDtoList = new ArrayList<>();
        expectedResponseDtoList.add(new CategoriaResponseDto());

        when(categoriaServicePort.listarCategorias()).thenReturn(categoriaModelList);
        when(categoriaResponseMapper.toResponseList(categoriaModelList)).thenReturn(expectedResponseDtoList);

        // Act
        List<CategoriaResponseDto> responseList = categoriaHandler.listarCategorias();

        // Assert
        assertEquals(expectedResponseDtoList, responseList);
        verify(categoriaServicePort, times(1)).listarCategorias();
        verify(categoriaResponseMapper, times(1)).toResponseList(categoriaModelList);
    }
}