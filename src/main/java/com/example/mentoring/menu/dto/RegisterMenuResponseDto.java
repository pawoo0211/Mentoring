package com.example.mentoring.menu.dto;

import lombok.Getter;

@Getter
public class RegisterMenuResponseDto {

    private boolean isSuccess;
    private String message;

    public RegisterMenuResponseDto(boolean isSuccess, String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
