package com.example.mentoring.order.out;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderOut {

    private boolean isSuccess;
    private String menu;
    private LocalDateTime orderTime;

    @Builder
    public OrderOut(boolean isSuccess, String menu, LocalDateTime orderTime){
        this.isSuccess = isSuccess;
        this.menu = menu;
        this.orderTime = orderTime;
    }

}
