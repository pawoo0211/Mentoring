package com.example.mentoring.controller;

import com.example.mentoring.order.dto.OrderRequestDto;
import com.example.mentoring.order.dto.OrderResponseDto;
import com.example.mentoring.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public OrderResponseDto placeOrder(@RequestBody @Valid OrderRequestDto orderRequestDto) {
        return orderService.placeOrder(orderRequestDto);
    }
}
