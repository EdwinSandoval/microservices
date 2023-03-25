package com.pragma.usuarioservice.infraestructure.out.jpa.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter
@Builder
public class UserEntity implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Debes especificar el nombre")
    private  String nombre;

    @Column
    @NotBlank(message = "Debes especificar el apellido")
    private String apellido;


    @Size(max = 13, message = "El maximo es 13 numeros")
    @Column
//    @NotBlank(message = "Debes especificar el telefono")
    private String celular;

    @Column
    @NotBlank(message = "Debes especificar el email")
    private String email;

    @Column
<<<<<<< HEAD
    @NotBlank(message = "Debes especificar la clave")
=======
    @NotBlank(message = "Debes especificar la password")
>>>>>>> 19968eaede9132f16e729d6e2710abf9d3b10c2a
    private String password;

    @Size(max = 8,min = 8, message = "El maximo 8 numeros")
    @Column
//    @NotBlank(message = "Debes especificar el dni")
    private String dni;//por preguntar

    @ManyToOne
    @JoinColumn(name = "idRol")//es el id que tiene la entidad rol
    private RolEntity rol;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
