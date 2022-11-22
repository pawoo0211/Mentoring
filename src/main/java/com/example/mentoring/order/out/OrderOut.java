package com.example.mentoring.order.out;

import com.example.mentoring.constant.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderOut{

    private Menu menu;
    private LocalDateTime orderTime;
    private boolean orderState;

    @Builder
    public OrderOut(Menu menu, LocalDateTime orderTime, boolean orderState){
        this.menu = menu;
        this.orderTime = orderTime;
        this.orderState = orderState;
    }
}
