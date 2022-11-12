package com.example.mentoring.order.model;

public class FoodMaker {

    public Food makeFood(String menu) {
        if (menu.equals("CHICKEN")) {
            return new Chicken();
        }
        else if (menu.equals("PIZZA")) {
            return new Pizza();
        }
        return null;
    }
}
