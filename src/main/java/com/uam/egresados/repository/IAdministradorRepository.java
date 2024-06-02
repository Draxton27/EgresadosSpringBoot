package com.uam.egresados.repository;

import com.uam.egresados.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdministradorRepository extends JpaRepository<Administrador, String> {

    @Query("select e from Administrador e where e.username = :username and e.password = :password")
    Optional<Administrador> findByUsernameAndPassword(String username , String password);


    @Query("select e from Administrador e where e.username = :username")
    Optional<Administrador> findByUsername(String username);

}
