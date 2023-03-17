package com.pragma.usuarioservice.domain.api;

import com.pragma.usuarioservice.domain.model.RolModel;

import java.util.List;

public interface IRolServicePort {

    void saveRol(RolModel rolModel);

    List<RolModel> getAllRols();
}
