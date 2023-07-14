package com.example.serviceplazoleta.infraestructure.input.rest;

import static org.junit.jupiter.api.Assertions.*;

import com.example.serviceplazoleta.application.dto.request.CategoriaRequestDto;
import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import com.example.serviceplazoleta.application.handler.ICategoriaHandler;
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
class CategoriaRestControllerTest {
    @Mock
    private ICategoriaHandler categoriaHandler;

    @InjectMocks
    private CategoriaRestController categoriaRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarCategoria_DeberiaDevolverResponseEntityConCategoriaResponseDtoYHttpStatusCreated() {
        // Arrange
        CategoriaRequestDto categoriaRequestDto = new CategoriaRequestDto();
        CategoriaResponseDto expectedResponseDto = new CategoriaResponseDto();
        when(categoriaHandler.guardarCategoria(categoriaRequestDto)).thenReturn(expectedResponseDto);

        // Act
        ResponseEntity<CategoriaResponseDto> response = categoriaRestController.guardarCategoria(categoriaRequestDto);

        // Assert
        assertEquals(expectedResponseDto, response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(categoriaHandler, times(1)).guardarCategoria(categoriaRequestDto);
    }

    @Test
    void listarCategorias_DeberiaDevolverResponseEntityConListaCategoriaResponseDtoYHttpStatusOk() {
        // Arrange
        List<CategoriaResponseDto> expectedResponseDtoList = new ArrayList<>();
        expectedResponseDtoList.add(new CategoriaResponseDto());
        when(categoriaHandler.listarCategorias()).thenReturn(expectedResponseDtoList);

        // Act
        ResponseEntity<List<CategoriaResponseDto>> response = categoriaRestController.listarCategorias();

        // Assert
        assertEquals(expectedResponseDtoList, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(categoriaHandler, times(1)).listarCategorias();
    }
}