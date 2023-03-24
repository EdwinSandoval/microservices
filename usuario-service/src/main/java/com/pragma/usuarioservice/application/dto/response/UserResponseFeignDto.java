package com.pragma.usuarioservice.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseFeignDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String dni;
    private RolResponseDto rol;//
}
