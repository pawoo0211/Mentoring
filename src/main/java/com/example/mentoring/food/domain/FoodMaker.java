package com.example.mentoring.food.domain;

public interface FoodMaker {

    public Food make();
    public String getMenu();

    /* 멘토님께 피드백 받기 전 코드, 새로운 메뉴가 추가되면 로직(소스코드)가 추가 됨
       추상화가 잘 되면 코드 수정 없이 메뉴추가가 가능하다!!
       클래스를 다양하고 풍부하게 이용하면 보다 객체지향적으로 클린하게 코드 작성이 가능

       기존에는 "FoodMaker"라는 클래스만 존재 -> "FoodMaker"를 인터페이스로 변경
       "FoodMaker"를 상속 받는 "ChickenMaker", "PizzaMaker"가 추가
       "FoodManager"를 추가하여 음식에 따른 Maker 호출

    public Food makeFood(String menu) {
        if (menu.equals("CHICKEN")) {
            return new Chicken();
        } else if (menu.equals("PIZZA")) {
            return new Pizza();
        }
        return null;
    }
     */
}
