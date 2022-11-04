package com.example.mentoring.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterMenuResponseDto {

    private boolean isSuccess;

    public RegisterMenuResponseDto(boolean isSuccess){
        this.isSuccess = isSuccess;
    }
}
