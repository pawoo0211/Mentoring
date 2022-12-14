package com.example.mentoring.food.domain;

import com.example.mentoring.constant.Menu;
import org.springframework.stereotype.Component;

@Component
class PizzaMaker implements FoodMaker {

    @Override
    public Food make() {
        return new Pizza();
    }

    @Override
    public Menu getMenu() {
        return Menu.PIZZA;
    }
}
