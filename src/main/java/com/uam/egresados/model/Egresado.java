package com.uam.egresados.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;



@Entity
@Table(name = "Egresado")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Egresado extends Identity implements UserDetails {

    @NotBlank
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]+$")
    private String primerNombre;

    @NotBlank
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]+$" )
    private String segundoNombre;

    @NotBlank
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]+$" )
    private String primerApellido;

    @NotBlank
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]+$" )
    private String segundoApellido;


    @NotNull
    private LocalDate fechaNacimiento;

    @Pattern(regexp = "^[0-9]+$")
    private String cif;

    @PastOrPresent
    private LocalDate fechaGraduacion;

    @NotNull
    private Posicion cargoActual;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "La contraseña debe contener al menos una mayuscula, una minuscula, un numero y 8 caracteres.")
    private String password;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String logInEmail;

    @ElementCollection
    private Set<Telefono> contactos;

    @ElementCollection
    private Set<Correo> correos;

    @ElementCollection
    private Set<Posicion> trabajos;

    @ElementCollection
    private Set<Carrera> carreras;

    @NotNull
    private Etnia etnia;

    @NotNull
    private Boolean aprobado;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("EGRESADO"));
    }

    @Override
    public String getUsername() {
        return logInEmail;
    }

    @Override
    public String getPassword() {
        return password;
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
