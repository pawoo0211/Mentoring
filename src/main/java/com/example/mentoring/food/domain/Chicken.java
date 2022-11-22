package com.example.mentoring.food.domain;

import com.example.mentoring.constant.Menu;

class Chicken extends Food {

    @Override
    public String getName() {
        return Menu.CHICKEN.getName();
    }
}
