package com.example.mentoring.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionResponseDto {

    private boolean isSuccess;
    private String errorMessage;

    @Builder
    public ExceptionResponseDto(boolean isSuccess, String errorMessage){
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }
}
