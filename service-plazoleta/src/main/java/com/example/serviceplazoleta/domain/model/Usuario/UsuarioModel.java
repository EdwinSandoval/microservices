package com.example.serviceplazoleta.domain.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    private Long id;

    private String nombre;

    private String apellido;

    private String celular;

    private String correo;

    private String clave;

    private String dni;


}
