package com.uam.egresados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EGRESADO")
public class Egresado extends Identity{
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private LocalDate fechaGraduacion;
    private Posicion cargoActual;
    private List<Telefono> contactos;
    private List<Correo> correos;
    private List<Posicion> trabajos;
    private List<Carrera> carreras;
    private Etnia etnia;

}
