package com.pragma.usuarioservice.application.dto.request;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequestDto {
    //solamente van los campos que interesan al hacer una peticion
    @NotBlank(message = "Ingrese el nombre, es obligatorio")
    private String nombre;

    @NotBlank(message = "Ingrese el apellido, es obligatorio")
    private String apellido;

    @NotBlank(message = "Ingrese el celular, es obligatorio")
    private String celular;

    @NotBlank(message = "Ingrese el correo, es obligatorio")
    @Email(message = "El correo electrónico no es válido")
    private String email;

    @NotBlank(message = "Ingrese contraseña, es obligatoria")
    private String password;

    @NotBlank(message = "Ingrese el dni, es obligatorio")
    @Pattern(regexp = "^[0-9]*$", message = "Debe ser numerico")
    @Size(max=8, message = "El dni no es valido")
    private String dni;

//    private UserRolRequestDto rol;
}
