package com.example.zajecia2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice

public class GlobalExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
