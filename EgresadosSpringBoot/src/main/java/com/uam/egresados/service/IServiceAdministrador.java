package com.uam.egresados.service;

import com.uam.egresados.model.Administrador;

import java.util.List;


public interface IServiceAdministrador {

    List<Administrador> getAll();

    List<Administrador> findBynombreAdminAndcontrasenia (String nombreAdmin, String contrsenia);

}
