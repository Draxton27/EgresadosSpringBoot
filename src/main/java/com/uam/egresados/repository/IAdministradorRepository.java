package com.uam.egresados.repository;

import com.uam.egresados.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAdministradorRepository extends JpaRepository<Administrador, String> {

    @Query("select e from Administrador e where e.nombreAdmin = :nombreAdmin and e.contrasenia = :contrasenia")
    Optional<Administrador> findAdministradorBynombreAdminAndcontrasenia(String nombreAdmin , String contrasenia);



}
