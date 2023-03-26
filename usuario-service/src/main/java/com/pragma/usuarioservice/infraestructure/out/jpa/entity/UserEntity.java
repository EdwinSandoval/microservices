package com.pragma.usuarioservice.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, length = 30)
//    @NotBlank(message = "Debes especificar el nombre")
    private  String nombre;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "Debes especificar el apellido")
    private String apellido;


    @Column(nullable = false, length = 13)
    @NotBlank(message = "Debes especificar el telefono")
    private String celular;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "Debes especificar el email")
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Debes especificar la clave")
    private String password;

    @Size(max = 8,min = 8, message = "El maximo 8 numeros")
    @Column(name = "id_document", nullable = false)
    @NotBlank(message = "Debes especificar el dni")
    private String dni;//por preguntar

    @ManyToOne
    @JoinColumn(name = "idRol")//es el id que tiene la entidad rol
    private RolEntity rol;



}
