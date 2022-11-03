package com.example.mentoring.order.controller;

import com.example.mentoring.order.dto.OrderRequestDto;
import com.example.mentoring.order.dto.OrderResponseDto;
import com.example.mentoring.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderResponseDto placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.placeOrder(orderRequestDto);
    }
}
