package com.example.mentoring.controller;

import com.example.mentoring.order.in.OrderIn;
import com.example.mentoring.order.out.OrderOut;
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
    public OrderOut placeOrder(@RequestBody @Valid OrderIn orderIn) {
        return orderService.placeOrder(orderIn);
    }
}
