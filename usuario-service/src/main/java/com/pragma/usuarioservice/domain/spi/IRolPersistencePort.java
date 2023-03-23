package com.pragma.usuarioservice.domain.spi;

import com.pragma.usuarioservice.domain.model.RolModel;

import java.util.List;

public interface IRolPersistencePort {
    void saveRols(RolModel rolModel);
    RolModel getRoleById(Long id);
    List<RolModel> getAllRols();


}
