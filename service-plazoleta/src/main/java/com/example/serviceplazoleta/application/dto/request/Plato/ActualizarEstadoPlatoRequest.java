package com.example.serviceplazoleta.application.dto.request.Plato;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class ActualizarEstadoPlatoRequest {
    private  Long id;

    private boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


}
