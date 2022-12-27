package com.example.mentoring.exception.domain;

import com.example.mentoring.constant.ExceptionKeyword;
import org.springframework.stereotype.Component;

@Component
public class CheckOpeningException extends MentoringException {

    private static final String MESSAGE = "주문 가능한 시간이 아닙니다.";

    public CheckOpeningException() {
        super(MESSAGE);
    }

    @Override
    public String getKeyword() {
        return ExceptionKeyword.CheckOpening.getKeyword();
    }
}
