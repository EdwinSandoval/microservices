package com.pragma.usuarioservice.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rol")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Long id;

    @Column(nullable = false, length = 20)
    private String nombre="USER";

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "rol")//la variable q esta dentro es la que se creo en la entidad usuario
    private List<UserEntity> usuarios;


}
