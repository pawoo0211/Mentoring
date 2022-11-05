package com.example.mentoring.order.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class OrderRequestDto {

    @NotEmpty(message = "메뉴를 입력해주세요.")
    private String menu;
    @NotNull(message = "가격을 입력해주세요,")
    private int price;

}
