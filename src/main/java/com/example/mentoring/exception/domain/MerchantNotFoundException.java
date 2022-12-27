package com.example.mentoring.exception.domain;

import com.example.mentoring.constant.ExceptionKeyword;
import org.springframework.stereotype.Component;

@Component
public class MerchantNotFoundException extends MentoringException {

    private static final String MESSAGE = "해당 가맹점은 존재하지 않는 가맹점입니다.";

    public MerchantNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public String getKeyword() {
        return ExceptionKeyword.Merchant.getKeyword();
    }
}
