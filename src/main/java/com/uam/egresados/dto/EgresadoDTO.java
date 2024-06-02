package com.uam.egresados.dto;

import com.uam.egresados.model.*;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class EgresadoDTO {
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
}
