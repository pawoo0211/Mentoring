package com.example.mentoring.order.service;

import com.example.mentoring.exception.domain.MenuNotFoundException;
import com.example.mentoring.menu.domain.Menu;
import com.example.mentoring.menu.domain.MenuRepository;
import com.example.mentoring.order.domain.Order;
import com.example.mentoring.order.domain.OrderRepository;
import com.example.mentoring.order.dto.OrderRequestDto;
import com.example.mentoring.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {

        // 주문 검증,
        Order order = verifyOrder(orderRequestDto);

        // 주문 내역 저장, 주문이 정상인 상태
        orderRepository.save(order);

        // 결과 반환
        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .isSuccess(order.isOrderState())
                .menu(order.getMenu())
                .orderTime(order.getOrderTime())
                .build();

        return orderResponseDto;
    }

    @Transactional
    private Order verifyOrder(OrderRequestDto orderRequestDto) {

        // 요청 주문에 따른 메뉴 검증 및 메뉴 생성
        Menu menu = menuRepository.findByMenu(orderRequestDto.getMenu())
                .orElseThrow(() -> new MenuNotFoundException());

        // 메뉴 검증 - 결제 금액이 비정상일 경우
        if(menu.getPrice() != orderRequestDto.getPrice()){
            log.info("Menu`s Price: "+ menu.getPrice());
            log.info("Order`s Price: "+orderRequestDto.getPrice());

            // 비정상 주문 객체 생성
            Order order = Order.builder()
                    .menu(orderRequestDto.getMenu())
                    .price(orderRequestDto.getPrice())
                    .orderState(false)
                    .build();

            // 비정상 주문 객체 반환
            return order;
        }

        // 메뉴 검증 - 결제 금액이 정상일 경우 주문 객체를 반환
        Order order = Order.builder()
                .menu(orderRequestDto.getMenu())
                .price(orderRequestDto.getPrice())
                .orderState(true)
                .build();

        return order;
    }
}

