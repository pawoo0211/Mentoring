package com.example.mentoring.constant;

/** 기존에 RegisteredMenus 는 db에 insert 목적으로 만들어진 enum이었는데,
 * 다른 로직에 적용되면서 이름과는 다르게 쓰이기 시작했습니다.
 * 이럴때는 새 Enum을 만들어 분리 또는 지금처럼 수정을 해주시는게 좋습니다.
 * */
public enum Menu {
    CHICKEN("CHICKEN"),
    PIZZA("PIZZA");
    private final String name;
    Menu(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
