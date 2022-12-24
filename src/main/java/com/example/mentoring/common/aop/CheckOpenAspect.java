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
    public Object checkOpeningHours(ProceedingJoinPoint joinPoint) throws Throwable{
        Object ret = joinPoint.proceed();
        Object object[] = joinPoint.getArgs();

        try {
            OrderIn orderIn = (OrderIn)object[0];
            MerchantEntity merchantEntity = merchantRepository.findById(orderIn.getMerchantId())
                    .orElseThrow(() -> new MerchantNotFoundException());

            if(!checkOpening(merchantEntity)){
                CheckOpeningException e = new CheckOpeningException();
                throw e;
            }
        }

        catch (CheckOpeningException e) {
            throw e;
        }

        return ret;
    }

    private boolean checkOpening(MerchantEntity merchantEntity){
        boolean result = true;
        LocalTime localTime = LocalTime.now();

        int currentHour = localTime.getHour();
        int currentMinute = localTime.getMinute();
        int openingHour = merchantEntity.getOpeningHours().getHour();
        int openingMinute = merchantEntity.getOpeningHours().getMinute();
        int closedHour = merchantEntity.getClosedHours().getHour();
        int closedMinute = merchantEntity.getClosedHours().getMinute();

        if (currentHour > openingHour && currentMinute > openingMinute){
            result = false;
        }

        if (closedHour < closedHour && closedMinute < closedMinute){
            result = false;
        }

        return result;
    }
}