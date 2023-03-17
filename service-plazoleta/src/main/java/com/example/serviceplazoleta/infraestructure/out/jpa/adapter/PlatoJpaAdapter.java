package com.example.serviceplazoleta.infraestructure.out.jpa.adapter;

import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.spi.IPlatoPersistencePort;
import com.example.serviceplazoleta.infraestructure.exception.NoDataFoundException;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PlatoEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPlatoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPlatoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlatoJpaAdapter implements IPlatoPersistencePort {

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    @Override
    public PlatoModel guardarPlato(PlatoModel platoModel) {
        PlatoEntity platoEntity = platoRepository.save(platoEntityMapper.toEntity(platoModel));
        return platoEntityMapper.toPlatoModel(platoEntity);
    }

    @Override
    public List<PlatoModel> listarPlatos() {
        List<PlatoEntity> entityList = platoRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return platoEntityMapper.toPlatoModelList(entityList);
    }
}
