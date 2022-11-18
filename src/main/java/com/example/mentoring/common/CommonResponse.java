package com.example.mentoring.common;

import lombok.Getter;

@Getter
public class CommonResponse<T> {

    private Boolean isSuccess;
    private final T out;

    // 기존 소스코드, 생성자를 이용해서 응답 값 구별(true or false)
    public CommonResponse(T out){
        this.isSuccess = true;
        this.out = out;
    }

    public CommonResponse(boolean isSuccess, T out){
        this.isSuccess = isSuccess;
        this.out = out;
    }

}
