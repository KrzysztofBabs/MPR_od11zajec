package com.example.zajecia2.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("blad! Nie ma takiego id");
    }
}
