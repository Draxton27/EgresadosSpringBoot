package com.uam.egresados.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posicion {
    private String posicionActual;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
}
