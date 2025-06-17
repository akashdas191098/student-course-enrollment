package com.scb.enrollment.exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ComponentScan(basePackages = "com.scb.enrollment")
@RestControllerAdvice(basePackages = "com.scb.enrollment")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> APIExceptionHandler(APIException ex){
        //ErrorInfo errorInfo = new ErrorInfo("false", ex.getMessage());
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<String> InvalidException(InvalidException message){
        //ErrorInfo errorInfo = new ErrorInfo("false", message.getMessage());
        return new ResponseEntity<String>(message.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
