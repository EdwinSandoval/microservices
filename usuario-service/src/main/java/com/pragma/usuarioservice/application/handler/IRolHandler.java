package com.pragma.usuarioservice.application.handler;

import com.pragma.usuarioservice.application.dto.request.RolRequestDto;
import com.pragma.usuarioservice.application.dto.response.RolResponseDto;

import java.util.List;

public interface IRolHandler {
    void saveRols(RolRequestDto rolRequestDto);

    List<RolResponseDto> getAllRols();


}
