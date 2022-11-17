package com.example.mentoring;

import lombok.Getter;

@Getter
public class ResponseEntity<T> {

    private Boolean isSuccess;
    private final T out;

    public ResponseEntity(T out){
        this.isSuccess = true;
        this.out = out;
    }

    public ResponseEntity(boolean isSuccess, T out){
        this.isSuccess = isSuccess;
        this.out = out;
    }
}
