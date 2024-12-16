package com.example.zajecia2.exceptions;

public class CantUpdateAuto_NotFoundException extends RuntimeException{
    public CantUpdateAuto_NotFoundException(){
        super("nie moge zaaktualizowac auto,bo nie ma takiego id!");
    }
}
