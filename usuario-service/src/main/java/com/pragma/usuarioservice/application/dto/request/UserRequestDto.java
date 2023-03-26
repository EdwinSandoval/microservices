package com.pragma.usuarioservice.application.dto.request;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequestDto {
    //solamente van los campos que interesan al hacer una peticion
    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El campo apellido es obligatorio")
    private String apellido;
    @NotBlank(message = "El campo celular es obligatorio")
    private String celular;
    @NotBlank(message = "El campo correo es obligatorio")
    @Email(message = "El correo electrónico no es válido")
    private String email;
    @NotBlank(message = "El campo contraseña es obligatorio")
    private String password;
    @NotBlank(message = "El campo documento de identidad es obligatorio")
    private String dni;

//    private UserRolRequestDto rol;//
}
