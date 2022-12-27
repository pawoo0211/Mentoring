package com.example.mentoring.constant;

public enum ExceptionKeyword {

    Merchant("Merchant"),
    Menu("Menu"),
    CheckOpening("CheckOpening");

    private final String keyword;

    ExceptionKeyword(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
