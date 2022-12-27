package com.example.mentoring.exception.domain;

import com.example.mentoring.constant.ExceptionKeyword;
import org.springframework.stereotype.Component;

@Component
public class MenuNotFoundException extends MentoringException {

    // log Message
    private static final String MESSAGE = "해당 메뉴는 존재하지 않는 메뉴입니다.";

    public MenuNotFoundException() {
        super(MESSAGE);
     }

    @Override
    public String getKeyword(){
        return ExceptionKeyword.Menu.getKeyword();
    }
}
