package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.CategoriaEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.ICategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class CategoriaJpaAdapterTest {

    @Mock
    private ICategoriaRepository categoriaRepository;

    @Mock
    private ICategoriaEntityMapper categoriaEntityMapper;

    @InjectMocks
    private CategoriaJpaAdapter categoriaJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarCategoria_DeberiaDevolverCategoriaModel() {
        // Arrange
        CategoriaModel inputModel = new CategoriaModel();
        CategoriaEntity savedEntity = new CategoriaEntity();
        when(categoriaRepository.save(any())).thenReturn(savedEntity);
        when(categoriaEntityMapper.toCategoriaModel(savedEntity)).thenReturn(inputModel);

        // Act
        CategoriaModel result = categoriaJpaAdapter.guardarCategoria(inputModel);

        // Assert
        assertNotNull(result);
        assertEquals(inputModel, result);
        verify(categoriaRepository, times(1)).save(any());
        verify(categoriaEntityMapper, times(1)).toCategoriaModel(savedEntity);
    }

    @Test
    void obtenerCategoriaId_DeberiaDevolverCategoriaModel() {
        // Arrange
        Long idCategoria = 1L;
        CategoriaEntity entity = new CategoriaEntity();
        CategoriaModel expectedModel = new CategoriaModel();
        when(categoriaRepository.findById(idCategoria)).thenReturn(Optional.of(entity));
        when(categoriaEntityMapper.toCategoriaModel(entity)).thenReturn(expectedModel);

        // Act
        CategoriaModel result = categoriaJpaAdapter.obtenerCategoriaId(idCategoria);

        // Assert
        assertNotNull(result);
        assertEquals(expectedModel, result);
        verify(categoriaRepository, times(1)).findById(idCategoria);
        verify(categoriaEntityMapper, times(1)).toCategoriaModel(entity);
    }

    @Test
    void obtenerCategoriaId_IdNoExistente_DeberiaLanzarExcepcion() {
        // Arrange
        Long idCategoria = 1L;
        when(categoriaRepository.findById(idCategoria)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NoDataFoundException.class, () -> categoriaJpaAdapter.obtenerCategoriaId(idCategoria));
        verify(categoriaRepository, times(1)).findById(idCategoria);
        verifyNoInteractions(categoriaEntityMapper);
    }

    @Test
    void listarCategorias_DeberiaDevolverListaNoVacia() {
        // Arrange
        List<CategoriaEntity> entityList = new ArrayList<>();
        entityList.add(new CategoriaEntity());
        when(categoriaRepository.findAll()).thenReturn(entityList);

        List<CategoriaModel> expectedModelList = new ArrayList<>();
        expectedModelList.add(new CategoriaModel());
        when(categoriaEntityMapper.toCategoriaModelList(entityList)).thenReturn(expectedModelList);

        // Act
        List<CategoriaModel> result = categoriaJpaAdapter.listarCategorias();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expectedModelList, result);
        verify(categoriaRepository, times(1)).findAll();
        verify(categoriaEntityMapper, times(1)).toCategoriaModelList(entityList);
    }

    @Test
    void listarCategorias_SinDatos_DeberiaLanzarExcepcion() {
        // Arrange
        when(categoriaRepository.findAll()).thenReturn(new ArrayList<>());

        // Act and Assert
        assertThrows(NoDataFoundException.class, () -> categoriaJpaAdapter.listarCategorias());
        verify(categoriaRepository, times(1)).findAll();
        verifyNoInteractions(categoriaEntityMapper);
    }
}