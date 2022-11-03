package com.example.mentoring.order.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponseDto {

    private boolean isSuccess;
    private String menu;
    private LocalDateTime orderTime;

    @Builder
    public OrderResponseDto(boolean isSuccess, String menu, LocalDateTime orderTime){
        this.isSuccess = isSuccess;
        this.menu = menu;
        this.orderTime = orderTime;
    }

}
