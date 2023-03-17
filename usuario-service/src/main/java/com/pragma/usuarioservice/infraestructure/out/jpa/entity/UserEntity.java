package com.pragma.usuarioservice.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @Column
    @NotNull(message = "Debes especificar el nombre")
    private  String nombre;

    @Column
    @NotNull(message = "Debes especificar el apellido")
    private String apellido;


    @Size(max = 13, message = "El maximo 13 numeros")
    @Column
    @NotNull(message = "Debes especificar el telefono")
    private String celular;

    @Column
    @NotNull(message = "Debes especificar el correo")
    private String correo;

    @Column
    @NotNull(message = "Debes especificar la clave")
    private String clave;

    @Size(max = 8,min = 8, message = "El maximo 8 numeros")
    @Column
    @NotNull(message = "Debes especificar el dni")
    private String dni;//por preguntar

    @ManyToOne
    @JoinColumn(name = "idRol")//es el id que tiene la entidad rol
    private RolEntity rol;



}
