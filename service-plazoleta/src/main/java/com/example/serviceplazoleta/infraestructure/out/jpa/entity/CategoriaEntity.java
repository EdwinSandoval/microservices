package com.example.serviceplazoleta.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "categoria")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String nombre;

    @Column
    private String descripcion;

    @OneToMany(mappedBy = "categoria")//la variable q esta dentro es la que se creo en la entidad usuario
    private List<PlatoEntity> platos;
}
