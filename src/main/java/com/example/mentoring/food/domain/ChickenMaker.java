package com.example.mentoring.food.domain;

import com.example.mentoring.constant.RegisteredMenus;
import org.springframework.stereotype.Component;

@Component
class ChickenMaker implements FoodMaker {

    @Override
    public Food make() {
        return new Chicken();
    }

    @Override
    public RegisteredMenus getMenu() {
        return RegisteredMenus.CHICKEN;
    }

}
