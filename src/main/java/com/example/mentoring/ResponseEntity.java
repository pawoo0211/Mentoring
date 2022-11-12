package com.example.mentoring;

import lombok.Getter;

@Getter
public class ResponseEntity<T> {

    private final Boolean isSuccess;
    private final T out;

    public ResponseEntity(boolean isSuccess, T out){
        this.isSuccess = isSuccess;
        this.out = out;
    }
}
