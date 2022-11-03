package com.example.mentoring.order.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "menu")
    private String menu;

    @Column(name = "price")
    private int price;

    @CreatedDate
    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @Column(name = "order_state")
    private boolean orderState;

    @Builder
    public Order(String menu, int price, boolean orderState){
        this.menu = menu;
        this.price = price;
        this.orderState = orderState;
    }
}
