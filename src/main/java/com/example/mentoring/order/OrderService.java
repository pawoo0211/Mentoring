package com.example.mentoring.order;

import com.example.mentoring.exception.domain.MenuNotFoundException;
import com.example.mentoring.menu.domain.Menu;
import com.example.mentoring.menu.domain.MenuRepository;
import com.example.mentoring.order.domain.Order;
import com.example.mentoring.order.domain.OrderRepository;
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

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public OrderOut placeOrder(OrderIn orderIn) {

        // 주문 검증,
        Order order = verifyOrder(orderIn);

        // 주문 내역 저장, 주문이 정상인 상태
        orderRepository.save(order);

        // 결과 반환
        OrderOut orderOut = OrderOut.builder()
                .isSuccess(order.isOrderState())
                .menu(order.getMenu())
                .orderTime(order.getOrderTime())
                .build();

        return orderOut;
    }

    @Transactional
    private Order verifyOrder(OrderIn orderIn) {

        // 요청 주문에 따른 메뉴 검증 및 메뉴 생성
        Menu menu = menuRepository.findByMenu(orderIn.getMenu())
                .orElseThrow(() -> new MenuNotFoundException());

        // 메뉴 검증 - 결제 금액이 비정상일 경우
        if(menu.getPrice() != orderIn.getPrice()){
            log.info("Menu`s Price: "+ menu.getPrice());
            log.info("Order`s Price: "+ orderIn.getPrice());

            // 비정상 주문 객체 생성
            Order order = Order.builder()
                    .menu(orderIn.getMenu())
                    .price(orderIn.getPrice())
                    .orderState(false)
                    .build();

            // 비정상 주문 객체 반환
            return order;
        }

        // 메뉴 검증 - 결제 금액이 정상일 경우 주문 객체를 반환
        Order order = Order.builder()
                .menu(orderIn.getMenu())
                .price(orderIn.getPrice())
                .orderState(true)
                .build();

        return order;
    }
}

