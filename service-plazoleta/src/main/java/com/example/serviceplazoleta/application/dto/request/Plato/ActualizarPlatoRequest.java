package com.example.serviceplazoleta.application.dto.request.Plato;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarPlatoRequest {

    private  Long id;

    private String descripcion;

    private int precio;


}
