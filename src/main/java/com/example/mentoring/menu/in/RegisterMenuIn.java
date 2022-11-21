package com.example.mentoring.menu.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor // "cannot deserialize from Object value" 해결, JSON -> 객체 생성시 기본(Default) 생성자 필요
public class RegisterMenuIn {

    @NotEmpty(message = "메뉴를 입력해주세요.")
    private String menu;
    @NotNull(message = "가격을 입력해주세요,")
    private int price;

    public RegisterMenuIn(String menu, int price){
        this.menu = menu;
        this.price = price;
    }
}
