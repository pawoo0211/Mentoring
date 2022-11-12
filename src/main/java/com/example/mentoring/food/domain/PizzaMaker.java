package com.example.mentoring.food.domain;

import org.springframework.stereotype.Component;

@Component
public class PizzaMaker implements FoodMaker {

    private String menu = "PIZZA";

    @Override
    public Food make() {
        return new Pizza();
    }

    @Override
    public String getMenu() {
        return menu;
    }
}
