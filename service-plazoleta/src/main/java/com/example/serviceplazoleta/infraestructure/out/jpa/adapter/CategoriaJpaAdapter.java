package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.spi.ICategoriaPersistencePort;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.CategoriaEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.ICategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

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
    public CategoriaModel obtenerCategoriaId(Long idRest) {
        return categoriaEntityMapper.toCategoriaModel(categoriaRepository.findById(idRest)
                .orElseThrow(NoDataFoundException::new));
    }

    @Override
    public List<CategoriaModel> listarCategorias() {
        List<CategoriaEntity> entityList = categoriaRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoriaEntityMapper.toCategoriaModelList(entityList);
    }

    @Override
    public List<CategoriaModel> listarCategoriaPaginados(Integer numeroPaginas, Integer elementoPorPagina) {
        Pageable pageable = PageRequest.of(numeroPaginas, elementoPorPagina,
                Sort.by("nombre"));

        return categoriaRepository.findAll(pageable)
                .stream()
                .map(categoriaEntityMapper::toCategoriaModel)
                .collect(Collectors.toList());
    }
}
