package com.example.mentoring.merchant;

import com.example.mentoring.merchant.domain.MerchantEntity;
import com.example.mentoring.merchant.domain.MerchantRepository;
import com.example.mentoring.merchant.in.MerchantIn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalTime;

@RequiredArgsConstructor
@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

    @PostConstruct
    private void merchantSetting(){

        register(new MerchantIn("멘토링 맛집1", LocalTime.of(8,30), LocalTime.of(20,0)));
        register(new MerchantIn("멘토링 맛집2", LocalTime.of(10,0), LocalTime.of(23,0)));
    }

    public MerchantEntity register(MerchantIn merchantIn) {

        MerchantEntity merchantEntity = MerchantEntity.builder()
                .name(merchantIn.getName())
                .openingHours(merchantIn.getOpeningHours())
                .closedHours(merchantIn.getClosedHours())
                .build();

        merchantRepository.save(merchantEntity);

        return merchantEntity;
    }
}
