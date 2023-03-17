package com.example.serviceplazoleta.application.handler;

import com.example.serviceplazoleta.application.dto.request.CategoriaRequestDto;
import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;

import java.util.List;

public interface ICategoriaHandler {

    CategoriaResponseDto guardarCategoria(CategoriaRequestDto categoriaRequestDto);

    List<CategoriaResponseDto> listarCategorias();
}
