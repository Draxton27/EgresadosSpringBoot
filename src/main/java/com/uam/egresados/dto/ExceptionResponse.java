package com.uam.egresados.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExceptionResponse {
    private RequestStatus status;
    private String message;
}
