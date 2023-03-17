package com.pragma.usuarioservice.application.handler.impl;

import com.pragma.usuarioservice.application.dto.request.RolRequestDto;
import com.pragma.usuarioservice.application.dto.response.RolResponseDto;
import com.pragma.usuarioservice.application.handler.IRolHandler;
import com.pragma.usuarioservice.application.mapper.IRolRequestMapper;
import com.pragma.usuarioservice.application.mapper.IRolResponseMapper;
import com.pragma.usuarioservice.domain.api.IRolServicePort;
import com.pragma.usuarioservice.domain.model.RolModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor//automaticamnete genera constructor a lo que hallamos definido como final
@Service//toma la clase como un bean y ya se puede inyectar
@Transactional//hace un roolback
public class RolHandler implements IRolHandler {

    private final IRolServicePort rolServicePort;
    private final IRolRequestMapper rolRequestMapper;
    private final IRolResponseMapper rolResponseMapper;

    @Override
    public void saveRols(RolRequestDto rolRequestDto) {
        RolModel rolModel = rolRequestMapper.toRol(rolRequestDto);
        rolServicePort.saveRol(rolModel);
    }

    @Override
    public List<RolResponseDto> getAllRols() {

        return rolResponseMapper.toResponseList(rolServicePort.getAllRols());
    }


}
