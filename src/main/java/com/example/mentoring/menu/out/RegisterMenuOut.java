package com.example.mentoring.menu.out;

import lombok.Getter;

@Getter
public class RegisterMenuOut {

    private String message;

    public RegisterMenuOut(String message){
        this.message = message;
    }
}
