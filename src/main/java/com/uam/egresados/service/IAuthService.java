package com.uam.egresados.service;

import com.uam.egresados.dto.Access;
import com.uam.egresados.dto.EgresadoDTO;
import com.uam.egresados.model.Egresado;

import java.util.Optional;

public interface IAuthService<T, R>{
    public Optional<T> authenticate(Access login);
}
