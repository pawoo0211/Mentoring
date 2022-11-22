package com.example.mentoring.order.in;

import com.example.mentoring.constant.Menu;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class OrderIn {

    private Menu menu;

    @NotNull(message = "가격을 입력해주세요,")
    private int price;

}
