package com.uam.egresados.service;

import com.uam.egresados.model.Egresado;

import java.util.List;
import java.util.Optional;

public interface IServiceEgresado {
    public List<Egresado> getAll();

    public Egresado save(Egresado egresado);

    public void delete(String id);

    List<Egresado> findByPrimerNombre(String nombre);

    List<Egresado> findByCorreosAndPassword(String email, String password);

    List<Egresado> getAllPagination(Integer pageNo, Integer pageSize, String sortBy);

     Optional<Egresado> findById(String id);

}
