package com.example.mentoring.food.domain;

import com.example.mentoring.constant.Menu;

class Pizza extends Food {

    @Override
    public String getName() {
        return Menu.PIZZA.getName();
    }
}
