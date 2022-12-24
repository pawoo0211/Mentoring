package com.example.mentoring.merchant.out;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class MerchantOut {

    @NotEmpty(message = "가맹점 이름을 입력해주세요.")
    private String name;
    private Long merchantId;

    @Builder
    public MerchantOut(Long merchantId, String name){
        this.merchantId = merchantId;
        this.name = name;
    }
}
