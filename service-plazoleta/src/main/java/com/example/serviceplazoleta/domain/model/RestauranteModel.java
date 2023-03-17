package com.example.serviceplazoleta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteModel {

    private Long id;

    private String nombre;

    private String direccion;

    private String telefono;

    private String urlLogo;

    private String nit;

    private Long idPropietario;


}
