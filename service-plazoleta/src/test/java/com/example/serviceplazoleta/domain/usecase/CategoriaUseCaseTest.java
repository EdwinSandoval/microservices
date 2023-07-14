package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.spi.ICategoriaPersistencePort;
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

class CategoriaUseCaseTest {
    @Mock
    private ICategoriaPersistencePort categoriaPersistencePort;

    @InjectMocks
    private CategoriaUseCase categoriaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarCategoria_DeberiaDevolverCategoriaModel() {
        // Arrange
        CategoriaModel inputModel = new CategoriaModel();
        CategoriaModel expectedModel = new CategoriaModel();
        when(categoriaPersistencePort.guardarCategoria(inputModel)).thenReturn(expectedModel);

        // Act
        CategoriaModel result = categoriaUseCase.guardarCategoria(inputModel);

        // Assert
        assertNotNull(result);
        assertEquals(expectedModel, result);
        verify(categoriaPersistencePort, times(1)).guardarCategoria(inputModel);
    }

    @Test
    void listarCategorias_DeberiaDevolverListaNoVacia() {
        // Arrange
        List<CategoriaModel> expectedModelList = new ArrayList<>();
        expectedModelList.add(new CategoriaModel());
        when(categoriaPersistencePort.listarCategorias()).thenReturn(expectedModelList);

        // Act
        List<CategoriaModel> result = categoriaUseCase.listarCategorias();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedModelList, result);
        verify(categoriaPersistencePort, times(1)).listarCategorias();
    }
}