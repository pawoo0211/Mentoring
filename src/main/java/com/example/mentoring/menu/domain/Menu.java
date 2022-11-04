package com.example.mentoring.menu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "menu")
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long menuId;

    @Column(name = "menu")
    private String menu;

    @Column(name = "price")
    private int price;

    @Builder
    public Menu(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }
}
