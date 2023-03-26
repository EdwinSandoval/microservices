package com.pragma.usuarioservice.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private  String nombre;

    @Column(nullable = false, length = 20)
    private String apellido;


    @Column(nullable = false, length = 13)
    private String celular;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String password;


    @Column( nullable = false)
    private String dni;//por preguntar

    @ManyToOne(cascade = CascadeType.MERGE, fetch =
            FetchType.EAGER)
    @JoinColumn(name = "idRol")//es el id que tiene la entidad rol
    private RolEntity rol;



}
