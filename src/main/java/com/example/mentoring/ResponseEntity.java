package com.example.mentoring;

public class ResponseEntity<T> {

    private final boolean isSuccess;

    public ResponseEntity(boolean isSuccess){
        this.isSuccess = isSuccess;
    }
}
