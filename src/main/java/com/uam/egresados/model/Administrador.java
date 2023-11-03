package com.uam.egresados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Administrador extends Identity{
    private String nombreAdmin;
    private String contrasenia;
}
