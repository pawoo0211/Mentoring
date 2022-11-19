package com.example.mentoring.food.domain;

import com.example.mentoring.constant.RegisteredMenus;

public class Pizza extends Food {

    @Override
    public String getName() {
        return RegisteredMenus.PIZZA.getName();
    }
}
