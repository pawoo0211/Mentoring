package com.example.mentoring.food.domain;

import org.springframework.stereotype.Component;

@Component
public class ChickenMaker implements FoodMaker {

    private String menu = "CHICKEN";

    @Override
    public Food make() {
        return new Chicken();
    }

    @Override
    public String getMenu() {
        return menu;
    }

}
