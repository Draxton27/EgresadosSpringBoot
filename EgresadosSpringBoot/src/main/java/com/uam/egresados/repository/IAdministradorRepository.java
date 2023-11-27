package com.uam.egresados.repository;

import com.uam.egresados.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdministradorRepository extends JpaRepository<Administrador, String> {

    @Query("select e from Administrador e where e.nombreAdmin = :nombreAdmin and e.contrasenia = :contrasenia")
    List<Administrador> findAdministradorBynombreAdminAndcontrasenia(String nombreAdmin , String contrasenia);


}
