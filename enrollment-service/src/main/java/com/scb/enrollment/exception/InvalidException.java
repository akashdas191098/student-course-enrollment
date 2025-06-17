package com.scb.enrollment.exception;

public class InvalidException extends RuntimeException{

    private String message;

    public InvalidException(String message) {
        super(String.format(message));
        this.message = message;
    }
}
