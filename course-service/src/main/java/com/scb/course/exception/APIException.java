package com.scb.course.exception;

public class APIException extends RuntimeException{

    private String message;

    public APIException(String message) {
        super(String.format(message));
        this.message = message;
    }
}
