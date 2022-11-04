package com.example.mentoring.exception.domain;

public class MenuNotFoundException extends RuntimeException {

    // log Message
    private static final String MESSAGE = "해당 메뉴는 존재하지 않는 메뉴입니다.";

    public MenuNotFoundException() {
         super(MESSAGE);
     }
}
