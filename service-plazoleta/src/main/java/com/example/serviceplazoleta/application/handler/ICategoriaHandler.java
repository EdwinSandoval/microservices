package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.CategoriaRequestDto;
import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import com.example.serviceplazoleta.application.dto.response.Restaurante.ListarRestauranteResponseDto;

import java.util.List;

public interface ICategoriaHandler {

    CategoriaResponseDto guardarCategoria(CategoriaRequestDto categoriaRequestDto);

    List<CategoriaResponseDto> listarCategorias();
    List<CategoriaResponseDto> listarCategoriasPaginados(Integer numeroPaginas,
                                                                   Integer elementoPorPagina);
}
