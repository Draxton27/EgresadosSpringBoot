package com.uam.egresados.repository;

import com.uam.egresados.model.Administrador;
import com.uam.egresados.model.Egresado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAdministradorRepository extends JpaRepository<Egresado, String>{
    @Query("select e from Administrador e where e.nombreAdmin =:nombreAdmin")
    Administrador findAdministradorByContrasenia(String nombre);
}
