package com.example.mentoring.controller;

import com.example.mentoring.common.CommonResponse;
import com.example.mentoring.merchant.MerchantService;
import com.example.mentoring.merchant.domain.MerchantEntity;
import com.example.mentoring.merchant.in.MerchantIn;
import com.example.mentoring.merchant.out.MerchantOut;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping("/merchant")
    public CommonResponse register(@RequestBody @Valid MerchantIn merchantIn){
        MerchantEntity merchantEntity = merchantService.register(merchantIn);

        MerchantOut merchantOut = MerchantOut.builder()
                .merchantId(merchantEntity.getMerchantId())
                .name(merchantEntity.getName())
                .build();

        return CommonResponse.ok(merchantOut);
    }
}