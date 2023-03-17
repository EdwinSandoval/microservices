package com.pragma.usuarioservice.application.dto.request;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    //solamente van los campos que interesan al hacer una peticion
    private String nombre;

    private String apellido;

    private String celular;

    private String correo;

    private String clave;

    private String dni;

    private UserRolRequestDto rol;//
}
