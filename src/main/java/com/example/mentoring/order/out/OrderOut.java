package com.example.mentoring.order.out;

import com.example.mentoring.constant.RegisteredMenus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderOut{

    private RegisteredMenus menu;
    private LocalDateTime orderTime;
    private boolean orderState;
}
