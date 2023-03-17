package com.example.serviceplazoleta.application.dto.response.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;

    private String nombre;

    private String apellido;

    private String celular;

    private String correo;

    private String clave;

    private String dni;

    public UserResponseDto(Long id) {
        this.id = id;
    }
}
