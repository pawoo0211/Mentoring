package com.example.mentoring.food.domain;

import com.example.mentoring.constant.RegisteredMenus;

public class Chicken extends Food {

    @Override
    public String getName() {
        return RegisteredMenus.CHICKEN.getName();
    }
}
