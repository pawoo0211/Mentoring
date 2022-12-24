package com.example.mentoring.merchant.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class MerchantIn {

    @NotEmpty(message = "가맹점 이름을 입력해주세요")
    private String name;
    private LocalTime openingHours;
    private LocalTime closedHours;

    public MerchantIn(String name, LocalTime openingHours, LocalTime closedHours){
        this.name = name;
        this.openingHours = openingHours;
        this.closedHours = closedHours;
    }
}
