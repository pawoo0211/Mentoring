package com.example.mentoring.exception.domain;

public abstract class MentoringException extends RuntimeException{

    public MentoringException(String message){
        super(message);
    }

    public abstract String getKeyword();
}
