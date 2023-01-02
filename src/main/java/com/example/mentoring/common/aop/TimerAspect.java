package com.example.mentoring.common.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimerAspect {

    @Around("@annotation(Timer)")
    public Object logExecutionTime(ProceedingJoinPoint jointPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object ret = jointPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("[Timer] Method`execution time is " + executionTime);
        return ret;
    }
}
