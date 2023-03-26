package com.pragma.usuarioservice.infraestructure.out.jpa.adapter;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;
import com.pragma.usuarioservice.infraestructure.exception.NoDataFoundException;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import com.pragma.usuarioservice.infraestructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IRolRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistencePort {

    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;


    @Override
    public void saveRols(RolModel rolModel) {
        RolEntity rolEntity = rolRepository.save(rolEntityMapper.toEntity(rolModel));
        rolEntityMapper.toRolModel(rolEntity);
    }

    @Override
    public RolModel getRoleById(Long id) {
        return rolEntityMapper.toRolModel(rolRepository.findById(id)
                .orElseThrow(NoDataFoundException::new));
    }


    @Override
    public List<RolModel> getAllRols() {
        List<RolEntity> entityList = rolRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return rolEntityMapper.toRolModelList(entityList);
    }
}
