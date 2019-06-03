package com.example.project.exceptions;

public class InvalidRequestBodyException extends RuntimeException{

    public InvalidRequestBodyException(String message) {
        super(message);
    }

}


