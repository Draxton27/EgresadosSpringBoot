package com.uam.egresados.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
    @JsonProperty("status")
    private RequestStatus status;

    @JsonProperty("message")
    private String message;

    public ExceptionResponse(String message) {
        this.status = RequestStatus.error;
        this.message = message;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
