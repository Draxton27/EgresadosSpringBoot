package com.uam.egresados.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;



@Entity
@Table(name = "Egresado")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Egresado extends Identity implements UserDetails {
    @Pattern(regexp="^[\\p{L}\\s]+$")
    private String nombreCompleto;

    @NotNull
    private LocalDate fechaNacimiento;

    @Pattern(regexp = "^[0-9]+$", message = "El campo CIF solo puede contener números")
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
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email invalido")
    private String logInEmail;

    @ElementCollection
    private Set<String> contactosTelefonicos;

    @ElementCollection
    private Set<String> correos;

    @ElementCollection
    private Set<Posicion> trabajos;

    @ElementCollection
    private Set<String> carreras;

    @NotNull
    private String etnia;

    @NotNull
    private Boolean aprobado;

    private String resumeLink;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_EGRESADO"));
    }

    @Override
    public String getUsername() {
        return logInEmail;
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
    public String getPassword() {
        return password;
    }


    @Override
    public boolean isEnabled() {
        return aprobado;
    }
}
