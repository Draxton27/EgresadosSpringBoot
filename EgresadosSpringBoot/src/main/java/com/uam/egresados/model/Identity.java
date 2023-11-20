package com.uam.egresados.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


//todas las clases pueden heredar esta clase para no hacerlo repetidamente
//ya que cada clase debe tener un id
@MappedSuperclass
@Getter
@Setter
public class Identity {

    @Id
    @GeneratedValue(generator = "system-uuid") //system-uuid es un numero alfanumerico aleatorio.
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;
}
