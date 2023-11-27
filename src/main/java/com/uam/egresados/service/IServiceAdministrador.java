package com.uam.egresados.service;

import com.uam.egresados.model.Administrador;

import java.util.List;
import java.util.Optional;


public interface IServiceAdministrador {

    List<Administrador> getAll();

    Optional<Administrador> findBynombreAdminAndcontrasenia (String nombreAdmin, String contrsenia);

    Administrador save(Administrador admin);
}
