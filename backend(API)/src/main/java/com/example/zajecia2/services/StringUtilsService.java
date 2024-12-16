package com.example.zajecia2.services;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class StringUtilsService {

    public String upper(String s){
        return s.toUpperCase();
    }

    public String lower(String s){
        return s.toLowerCase();
    }

    public String firstBigger(String s){
        s = s.toLowerCase();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        return s;

    }
}
