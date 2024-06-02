package com.uam.egresados.service;


import com.uam.egresados.model.Form;

import java.util.List;
import java.util.Optional;

public interface IServiceForm {

    List<Form> getAll();

    Form save(Form form);

    void delete(String id);

    Optional<Form> findById(String id);

    Optional<Form> findByName(String name);
}
