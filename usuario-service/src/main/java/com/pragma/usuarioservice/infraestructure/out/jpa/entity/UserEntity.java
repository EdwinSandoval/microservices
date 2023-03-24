package com.pragma.usuarioservice.infraestructure.out.jpa.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private Long id;

    @Column( nullable = false, length = 30)
    private  String nombre;

    @Column( nullable = false, length = 20)
    private String apellido;

    @Column( nullable = false, length = 13)
    private String celular;
    @Column( nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;


    @Column(nullable = false,length = 8)
    private String dni;//por preguntar

    @ManyToOne
    @JoinColumn(name = "idRol",nullable = false)//es el id que tiene la entidad rol
    private RolEntity rol;



}
