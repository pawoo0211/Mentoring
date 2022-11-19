package com.example.mentoring.food.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FoodManager implements InitializingBean {

    private final ApplicationContext applicationContext;
    private Map<String, FoodMaker> foodMakerMap = new HashMap<>();

    /* 기존의 소스코드는 "API"가 호출 될 때마다 계속해서 반복문을 돌아야하는 구조
     * 하지만 현재 로직은 스프링 컨테이너가 생성(1번 호출)되고 "foodMakerMap"에  "FoodMaker"들이 전부 들어있는 구조
     * 즉 반복문이 1번만 돌게 되기 때문에 기존의 로직으로부터 성능 향상
     */
    @Override
    public void afterPropertiesSet() throws IllegalAccessException {
        Collection<FoodMaker> foodMakers = applicationContext.getBeansOfType(FoodMaker.class).values();

        for (FoodMaker foodMaker : foodMakers) {
            // if("~" != null)인 이유는 에러 객체가 생성되면 그 때 에러 발생 여부를 알 수 있기 때문
            if (foodMakerMap.put(foodMaker.getMenu().getName(), foodMaker) != null) {
                throw new IllegalAccessException("Put Process Exception in foodMaker");
            }
        }
    }

    public Food make(String menu) {
        FoodMaker foodMaker = foodMakerMap.get(menu);
        return foodMaker.make();
    }

    /* 기존 소소코드
    * menu 이름을 통해 적합한 "FoodMaker"를 반환하는 로직
    public FoodMaker choiceFoodMaker(String menu) {
        return foodMakerList.stream()
                .filter(foodMaker -> foodMaker.getMenu().getName().equals(menu))
                .findFirst()
                .orElseThrow(() -> new MenuNotFoundException());
    }
    */
}