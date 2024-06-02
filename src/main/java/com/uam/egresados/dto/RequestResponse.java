package com.uam.egresados.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestResponse<T> {

    @JsonProperty("status")
    private RequestStatus status;

    @JsonProperty("data")
    private T data;
    public RequestResponse(RequestStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }
}