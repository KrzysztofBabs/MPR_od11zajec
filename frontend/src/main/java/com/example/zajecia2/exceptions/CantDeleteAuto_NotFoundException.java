package com.example.zajecia2.exceptions;

public class CantDeleteAuto_NotFoundException extends RuntimeException{
    public CantDeleteAuto_NotFoundException() {
        super("nie moge usunac takiego auta, poniewaz ono nie istnieje!");
    }
}
