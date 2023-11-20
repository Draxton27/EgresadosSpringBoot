package com.uam.egresados.service;


import com.uam.egresados.model.Egresado;
import com.uam.egresados.model.Form;

import java.util.List;
import java.util.Optional;

public interface IServiceForm {

    public List<Form> getAll();

    public Form save(Form form);

    public void delete(String id);

    Optional<Form> findById(String id);

}
