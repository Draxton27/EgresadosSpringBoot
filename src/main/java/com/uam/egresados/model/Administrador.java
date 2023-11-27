package com.uam.egresados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Administrador")
public class Administrador extends Identity{
    private String nombreAdmin;
    private String contrasenia;
}
