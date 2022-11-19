package com.example.mentoring.food.domain;

import com.example.mentoring.exception.domain.MenuNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodManager {

    private final List<FoodMaker> foodMakerList;

    public FoodMaker choiceFoodMaker(String menu) {
        return foodMakerList.stream()
                .filter(foodMaker -> foodMaker.getMenu().getName().equals(menu))
                .findFirst()
                .orElseThrow(() -> new MenuNotFoundException());
    }
}
