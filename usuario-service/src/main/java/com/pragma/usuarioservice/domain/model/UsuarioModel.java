package com.pragma.usuarioservice.domain.model;

import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import lombok.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

public class UsuarioModel {

    private Long id;
    private String nombre;
    private String apellido;
    private String celular;
    private String correo;
    private String clave;
    private String dni;
    private RolModel rol;

    public UsuarioModel(Long id, String nombre, String apellido, String celular, String correo, String clave, String dni, RolModel rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.clave = clave;
        this.dni = dni;
        this.rol = rol;
    }

    public UsuarioModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public RolModel getRol() {
        return rol;
    }

    public void setRol(RolModel rol) {
        this.rol = rol;
    }

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

    public boolean numeroTelefonoValido(){
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
