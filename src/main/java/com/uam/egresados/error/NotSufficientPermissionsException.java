package com.uam.egresados.error;

public class NotSufficientPermissionsException extends Exception{
    public NotSufficientPermissionsException(String message) {
        super(message);
    }
}
