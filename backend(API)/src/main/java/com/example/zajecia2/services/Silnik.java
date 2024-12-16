package com.example.zajecia2.services;

import com.example.zajecia2.model.Auto;
import jakarta.persistence.Entity;

@Entity
public class Silnik extends Auto {
    public Silnik(String model,int rokProdukcji){
        super(model,rokProdukcji);
    }


    public Silnik() {
    }
}
