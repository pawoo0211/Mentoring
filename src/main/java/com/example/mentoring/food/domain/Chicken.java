package com.example.mentoring.food.domain;

import com.example.mentoring.constant.RegisteredMenus;

class Chicken extends Food {

    @Override
    public String getName() {
        return RegisteredMenus.CHICKEN.getName();
    }
}
