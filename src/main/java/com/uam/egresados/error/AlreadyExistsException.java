package com.uam.egresados.error;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class AlreadyExistsException extends Exception{

    public AlreadyExistsException(String message){
        super(message);
    }
}
