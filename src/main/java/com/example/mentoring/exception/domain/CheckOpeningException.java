package com.example.mentoring.exception.domain;

public class CheckOpeningException extends RuntimeException{

    private static final String MESSAGE = "주문 가능한 시간이 아닙니다.";

    public CheckOpeningException() {
        super(MESSAGE);
    }
}
