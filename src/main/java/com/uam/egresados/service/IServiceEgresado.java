package com.uam.egresados.service;

import com.uam.egresados.dto.EgresadoDTO;
import com.uam.egresados.model.Egresado;

import java.util.List;
import java.util.Optional;

public interface IServiceEgresado {
    List<Egresado> getAll();

    Egresado save(Egresado egresado);

    void delete(String id);

    List<Egresado> findByFirstName(String nombre);

    Optional<Egresado> findByEmail(String email);

    List<Egresado> getAllPagination(Integer pageNo, Integer pageSize, String sortBy);

     Optional<Egresado> findById(String id);

     Egresado signUp(EgresadoDTO egresadoDTO);
}
