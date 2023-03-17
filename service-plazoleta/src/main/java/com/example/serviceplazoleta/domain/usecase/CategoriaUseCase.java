package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.domain.api.ICategoriaServicePort;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.spi.ICategoriaPersistencePort;

import java.util.List;

public class CategoriaUseCase implements ICategoriaServicePort {

    private final ICategoriaPersistencePort categoriaPersistencePort;

    public CategoriaUseCase(ICategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Override
    public CategoriaModel guardarCategoria(CategoriaModel categoriaModel) {
        return  categoriaPersistencePort.guardarCategoria(categoriaModel);
    }

    @Override
    public List<CategoriaModel> listarCategorias() {
        return categoriaPersistencePort.listarCategorias();
    }
}
