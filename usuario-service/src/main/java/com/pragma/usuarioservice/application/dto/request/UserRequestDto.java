package com.pragma.usuarioservice.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequestDto {

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
    @Pattern(regexp = "^[0-9]*$", message = "El documento de identidad debe ser numerico")
    @Size(min = 5, max=11, message = "no es valida")
    private String dni;


}
