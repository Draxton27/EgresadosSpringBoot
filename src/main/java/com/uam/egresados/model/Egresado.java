package com.uam.egresados.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EGRESADO")
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

    @ElementCollection
    private List<Telefono> contactos;

    @ElementCollection
    private List<Correo> correos;

    @ElementCollection
    private List<Posicion> trabajos;

    @ElementCollection
    private List<Carrera> carreras;
    private Etnia etnia;

}
