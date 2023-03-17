package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.CategoriaRequestDto;
import com.example.serviceplazoleta.application.dto.response.CategoriaResponseDto;
import com.example.serviceplazoleta.application.handler.ICategoriaHandler;
import com.example.serviceplazoleta.application.mapper.ICategoriaRequestMapper;
import com.example.serviceplazoleta.application.mapper.ICategoriaResponseMapper;
import com.example.serviceplazoleta.domain.api.ICategoriaServicePort;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor//automaticamnete genera constructor a lo que hallamos definido como final
@Service//toma la clase como un bean y ya se puede inyectar
@Transactional//hace un roolback
public class CategoriaHandler implements ICategoriaHandler {

    private final ICategoriaServicePort categoriaServicePort;
    private final ICategoriaRequestMapper categoriaRequestMapper;
    private final ICategoriaResponseMapper categoriaResponseMapper;

    @Override
    public CategoriaResponseDto guardarCategoria(CategoriaRequestDto categoriaRequestDto) {
        CategoriaModel categoriaModel = categoriaRequestMapper.toCategoria(categoriaRequestDto);
        return categoriaResponseMapper.toResponse(categoriaServicePort.guardarCategoria(categoriaModel));
    }

    @Override
    public List<CategoriaResponseDto> listarCategorias() {
        return categoriaResponseMapper.toResponseList(categoriaServicePort.listarCategorias());
    }

}
