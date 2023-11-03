package com.uam.egresados.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Correo {
    private String correo;
}
