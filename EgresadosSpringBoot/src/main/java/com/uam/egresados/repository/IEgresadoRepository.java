package com.uam.egresados.repository;

import com.uam.egresados.model.Egresado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEgresadoRepository extends JpaRepository<Egresado, String> {
    @Query("select e from Egresado e where e.primerNombre = :primerNombre")
    List<Egresado> findEgresadoByPrimerNombre(String primerNombre);

    @Query("select e from Egresado e where e.logInEmail = :email and e.password = :password")
    List<Egresado> findEgresadoByCorreosAndPassword(String email ,String password);
}
