package com.uam.egresados.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDate;
import java.util.Optional;

@Embeddable
@Data
public class Posicion {
    private String posicionActual;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
}
