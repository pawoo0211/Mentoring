package com.example.mentoring.merchant.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MerchantOut {

    private String name;
    private Long merchantId;

    @Builder
    public MerchantOut(Long merchantId, String name){
        this.merchantId = merchantId;
        this.name = name;
    }
}
