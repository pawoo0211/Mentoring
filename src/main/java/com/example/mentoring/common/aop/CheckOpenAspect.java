package com.example.mentoring.common.aop;

import com.example.mentoring.exception.domain.CheckOpeningException;
import com.example.mentoring.exception.domain.MerchantNotFoundException;
import com.example.mentoring.merchant.domain.MerchantEntity;
import com.example.mentoring.merchant.domain.MerchantRepository;
import com.example.mentoring.order.in.OrderIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Slf4j
@RequiredArgsConstructor
@Component
@Aspect
public class CheckOpenAspect {

    private final MerchantRepository merchantRepository;

    @Around("@annotation(CheckOpeningHours)")
    public Object checkOpeningHours(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object[] = joinPoint.getArgs();

        OrderIn orderIn = (OrderIn) object[0];
        MerchantEntity merchantEntity = merchantRepository.findById(orderIn.getMerchantId())
                .orElseThrow(() -> new MerchantNotFoundException());

        if (!checkOpening(merchantEntity)) {
            throw new CheckOpeningException();
        }

        return joinPoint.proceed();
    }

    private boolean checkOpening(MerchantEntity merchantEntity) {
        boolean result = false;
        LocalTime now = LocalTime.now();

        if (now.isAfter(merchantEntity.getOpeningHours()) && now.isBefore(merchantEntity.getClosedHours())) {
            result = true;
        }

        return result;
    }
}