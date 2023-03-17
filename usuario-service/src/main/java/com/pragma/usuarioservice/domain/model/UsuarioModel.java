package com.pragma.usuarioservice.domain.model;

import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private RolModel rol;

    public boolean validarEmail(){
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
//        String email = "info@programacionextrema.com";
        String email = this.correo;
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numeroValido(){
        String numero=this.celular;
        if (numero.substring(0,1).equals("+") && numero.substring(1,numero.length()).matches("[0-9]*") ||
                numero.substring(0,numero.length()).matches("[0-9]*")  ){
            System.out.println("holaaaaaaaaaaa "+numero.substring(0,numero.length())+" val "+numero.substring(0,1).equals("+"));
            return true;
        }
        return false;
    }

    public boolean dniValidate(){
        if (this.dni.matches("[0-9]*")){
            return true;
        }
        return false;
    }
}
