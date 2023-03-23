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
