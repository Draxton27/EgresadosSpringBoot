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

    private Set<String> contactos;

    private Set<String> correos;

    private Set<Posicion> trabajos;

    private Set<String> carreras;

    @NotNull
    private String etnia;

    @NotNull
    private Boolean aprobado;
}
