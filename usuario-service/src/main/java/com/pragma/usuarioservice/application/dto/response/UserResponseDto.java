package com.pragma.usuarioservice.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    //para una respuesta si interesa ver el id

    private Long id;

    private String nombre;

    private String apellido;

    private String celular;

    private String correo;

    private String clave;

    private String dni;

    private RolResponseDto rol;//
}
