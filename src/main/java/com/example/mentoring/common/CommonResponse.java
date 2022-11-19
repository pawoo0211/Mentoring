package com.example.mentoring.common;

import lombok.Getter;

@Getter
public class CommonResponse<T> {

    private static Boolean isSuccess;
    private final T out;

    /* "CommonResponse" 생성자를 이용한 정상 응답, 비정상 응답 반환
    // 기존 소스코드, 생성자를 이용해서 응답 값 구별(true or false)
    public CommonResponse(T out){
        this.isSuccess = true;
        this.out = out;
    }
    // 기존 소스코드, 생성자를 이용해서 응답 값 구별(true or false)
    public CommonResponse(boolean isSuccess, T out){
        this.isSuccess = isSuccess;
        this.out = out;
    }
     */

    public CommonResponse(Boolean isSuccess, T out){
        this.isSuccess = isSuccess;
        this.out = out;
    }

    // 생성자 방법에서 "Static method"를 이용한 방법으로 리팩터링
    // "static"의 특성으로 인해 인자 값에 "Generic"을 사용할 수 없음 -> "Generic" 메서드로 변환
    private static <T> CommonResponse ok(T out){
        return new CommonResponse(true, out);
    }

    private static <T> CommonResponse fail(T out){
        return new CommonResponse(false, out);
    }
}