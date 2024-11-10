package com.uam.egresados.service;

import java.util.Optional;

public interface IAuthService<T, R>{
    Optional<T> authenticate(R login);
}