package com.uam.egresados.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Egresado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Egresado extends Identity{

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;

    private LocalDate fechaGraduacion;
    private Posicion cargoActual;
    private String password;

    @ElementCollection
    private Set<Telefono> contactos;

    @ElementCollection
    private Set<Correo> correos;

    @ElementCollection
    private Set<Posicion> trabajos;

    @ElementCollection
    private Set<Carrera> carreras;
    private Etnia etnia;

}
