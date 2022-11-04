package com.example.mentoring.order.service;

import com.example.mentoring.menu.domain.Menu;
import com.example.mentoring.menu.domain.MenuRepository;
import com.example.mentoring.order.domain.Order;
import com.example.mentoring.order.domain.OrderRepository;
import com.example.mentoring.order.dto.OrderRequestDto;
import com.example.mentoring.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Transactional
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {

        // 주문 성공 체크




        // 주문 내역 저장
        Order order = Order.builder()
                .menu(orderRequestDto.getMenu())
                .price(orderRequestDto.getPrice())
                .orderState(true)
                .build();

        orderRepository.save(order);


        // 결고 반환
        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .isSuccess(true)
                .menu(order.getMenu())
                .orderTime(order.getOrderTime())
                .build();

        return orderResponseDto;
    }
}
