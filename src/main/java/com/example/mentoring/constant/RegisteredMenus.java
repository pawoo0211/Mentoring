package com.example.mentoring.constant;

public enum RegisteredMenus {

    CHICKEN("CHICKEN", 20000),
    PIZZA("PIZZA", 25000);

    private final String name;
    private final int price;

    RegisteredMenus(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}
