package com.uam.egresados.dto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class RequestResponse<T>{
    private RequestStatus status;
    private T data;
}
