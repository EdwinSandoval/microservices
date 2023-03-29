package com.example.serviceplazoleta.domain.api;

import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.model.RestauranteModel;

import java.util.List;

public interface ICategoriaServicePort {

    CategoriaModel guardarCategoria(CategoriaModel categoriaModel);

    List<CategoriaModel> listarCategorias();
    List<CategoriaModel> listarCategoriasPaginados(Integer numeroPaginas,
                                                       Integer elementoPorPagina);
}
