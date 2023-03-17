package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.spi.ICategoriaPersistencePort;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.CategoriaEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.ICategoriaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CategoriaJpaAdapter implements ICategoriaPersistencePort {

    private final ICategoriaRepository categoriaRepository;
    private final ICategoriaEntityMapper categoriaEntityMapper;
    @Override
    public CategoriaModel guardarCategoria(CategoriaModel categoriaModel) {
        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaEntityMapper.toEntity(categoriaModel));
        return categoriaEntityMapper.toCategoriaModel(categoriaEntity);
    }

    @Override
    public List<CategoriaModel> listarCategorias() {
        List<CategoriaEntity> entityList = categoriaRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoriaEntityMapper.toCategoriaModelList(entityList);
    }
}
