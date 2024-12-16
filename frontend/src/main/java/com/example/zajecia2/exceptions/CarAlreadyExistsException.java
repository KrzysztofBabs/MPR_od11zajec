package com.example.zajecia2.exceptions;

public class CarAlreadyExistsException extends RuntimeException{
    public CarAlreadyExistsException(){
        super("Auto juz istnieje!");
    }
}
