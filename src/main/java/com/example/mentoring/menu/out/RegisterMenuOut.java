package com.example.mentoring.menu.out;

import lombok.Getter;

@Getter
public class RegisterMenuOut {

    private boolean isSuccess;
    private String message;

    public RegisterMenuOut(boolean isSuccess, String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
