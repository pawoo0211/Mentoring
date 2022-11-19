package com.example.mentoring.order;

import com.example.mentoring.exception.domain.MenuNotFoundException;
import com.example.mentoring.food.domain.FoodManager;
import com.example.mentoring.menu.domain.MenuEntity;
import com.example.mentoring.menu.domain.MenuRepository;
import com.example.mentoring.order.domain.OrderEntity;
import com.example.mentoring.order.domain.OrderRepository;
import com.example.mentoring.order.in.OrderIn;
import com.example.mentoring.food.domain.Food;
import com.example.mentoring.food.domain.FoodMaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final FoodManager foodManager;

    public OrderEntity placeOrder(OrderIn orderIn) {

        // 주문 검증,
        OrderEntity orderEntity = verifyOrder(orderIn);

        // 주문 내역 저장
        orderRepository.save(orderEntity);

        // 주문 검증으로 생성된 주문 객체 반환
        return orderEntity;
    }

    private OrderEntity verifyOrder(OrderIn orderIn) {

        // 요청 주문에 따른 메뉴 검증 및 메뉴 생성
        MenuEntity menuEntity = menuRepository.findByMenu(orderIn.getMenu())
                .orElseThrow(() -> new MenuNotFoundException());

        // 메뉴 검증 - 결제 금액이 비정상일 경우
        if (menuEntity.getPrice() != orderIn.getPrice()) {
            log.info("Menu`s Price: " + menuEntity.getPrice());
            log.info("Order`s Price: " + orderIn.getPrice());

            // 비정상 주문 객체 생성
            OrderEntity orderEntity = OrderEntity.builder()
                    .menu(orderIn.getMenu())
                    .price(orderIn.getPrice())
                    .orderState(false) // 재수정
                    .build();

            // 비정상 주문 객체 반환
            return orderEntity;
        }

        // 메뉴 검증 - 결제 금액이 정상인 경우
        OrderEntity orderEntity = OrderEntity.builder()
                .menu(orderIn.getMenu())
                .price(orderIn.getPrice())
                .orderState(true)
                .build();

        /* 기존 소스코드
        FoodMaker foodMaker = foodManager.choiceFoodMaker(orderEntity.getMenu());
        Food food = foodMaker.make();
        */

        // "FoodManager"의 하위 객체들은 전부 정보은닉 상태 되어야 함
        Food food = foodManager.make(orderEntity.getMenu());
        log.info("Requested Menu is " + food.getName());

        // 정상 주문 객체 반환
        return orderEntity;
    }
}