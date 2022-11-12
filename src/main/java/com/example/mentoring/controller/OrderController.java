package com.example.mentoring.controller;

import com.example.mentoring.ResponseEntity;
import com.example.mentoring.order.domain.OrderEntity;
import com.example.mentoring.order.in.OrderIn;
import com.example.mentoring.order.out.OrderOut;
import com.example.mentoring.order.OrderService;
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
    public ResponseEntity placeOrder(@RequestBody @Valid OrderIn orderIn) {
        OrderEntity orderEntity = orderService.placeOrder(orderIn);

        // 주문 DTO 생성, 주문 상태가 정상일 경우로 가정(중복코드 제거를 위해)
        OrderOut orderOut = OrderOut.builder()
                .menu(orderEntity.getMenu())
                .orderTime(orderEntity.getCreatedDate())
                .orderState(true)
                .build();

        // 비정상 응답 반환
        if (!orderEntity.isOrderState()) {
            orderOut.setOrderState(false);
            return new ResponseEntity(false, orderOut);
        }

        // 정상 응답 반환
        return new ResponseEntity(true, orderOut);
    }
}
