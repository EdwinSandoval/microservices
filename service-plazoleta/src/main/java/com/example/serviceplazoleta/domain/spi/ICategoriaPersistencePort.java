package com.example.serviceplazoleta.domain.spi;

import com.example.serviceplazoleta.domain.model.CategoriaModel;

import java.util.List;

public interface ICategoriaPersistencePort {

    CategoriaModel guardarCategoria(CategoriaModel categoriaModel);

    List<CategoriaModel> listarCategorias();
}
