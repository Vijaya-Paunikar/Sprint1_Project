package com.example.exception;

public class InternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InternalServerErrorException(String message) {
    	throw new InternalServerErrorException("Custom message for internal server error");
    }
}

