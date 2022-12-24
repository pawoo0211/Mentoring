package com.example.mentoring.exception.domain;

public class MerchantNotFoundException extends RuntimeException{

    private static final String MESSAGE = "해당 가맹점은 존재하지 않는 가맹점입니다.";

    public MerchantNotFoundException() {
        super(MESSAGE);
    }
}
