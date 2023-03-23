package com.pragma.usuarioservice.configuration.auth.Request;

import com.pragma.usuarioservice.application.dto.request.UserRolRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nombre;

    private String apellido;

    private String celular;

    private String email;

    private String password;

    private String dni;

    private UserRolRequestDto rol;

}
