package com.uam.egresados.error;

import lombok.NoArgsConstructor;

public class InternalServerErrorException extends Exception{

    public InternalServerErrorException(String message){
        super(message);
    }
}
