package com.example.mentoring.order;

import com.example.mentoring.exception.domain.MenuNotFoundException;
import com.example.mentoring.menu.domain.MenuEntity;
import com.example.mentoring.menu.domain.MenuEntityRepository;
import com.example.mentoring.order.domain.OrderEntity;
import com.example.mentoring.order.domain.OrderEntityRepository;
import com.example.mentoring.order.in.OrderIn;
import com.example.mentoring.order.out.OrderOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderEntityRepository orderEntityRepository;
    private final MenuEntityRepository menuEntityRepository;

    public OrderOut placeOrder(OrderIn orderIn) {

        // 주문 검증,
        OrderEntity orderEntity = verifyOrder(orderIn);

        // 주문 내역 저장, 주문이 정상인 상태
        orderEntityRepository.save(orderEntity);

        // 결과 반환
        OrderOut orderOut = OrderOut.builder()
                .isSuccess(orderEntity.isOrderState())
                .menu(orderEntity.getMenu())
                .orderTime(orderEntity.getCreatedDate())
                .build();

        return orderOut;
    }

    private OrderEntity verifyOrder(OrderIn orderIn) {

        // 요청 주문에 따른 메뉴 검증 및 메뉴 생성
        MenuEntity menuEntity = menuEntityRepository.findByMenu(orderIn.getMenu())
                .orElseThrow(() -> new MenuNotFoundException());

        // 메뉴 검증 - 결제 금액이 비정상일 경우
        if(menuEntity.getPrice() != orderIn.getPrice()){
            log.info("Menu`s Price: "+ menuEntity.getPrice());
            log.info("Order`s Price: "+ orderIn.getPrice());

            // 비정상 주문 객체 생성
            OrderEntity orderEntity = OrderEntity.builder()
                    .menu(orderIn.getMenu())
                    .price(orderIn.getPrice())
                    .orderState(false)
                    .build();

            // 비정상 주문 객체 반환
            return orderEntity;
        }

        // 메뉴 검증 - 결제 금액이 정상일 경우 주문 객체를 반환
        OrderEntity orderEntity = OrderEntity.builder()
                .menu(orderIn.getMenu())
                .price(orderIn.getPrice())
                .orderState(true)
                .build();

        return orderEntity;
    }
}

