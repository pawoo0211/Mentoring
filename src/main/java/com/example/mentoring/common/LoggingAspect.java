package com.example.mentoring.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Around("@annotation(Timer)")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.currentTimeMillis();
        Object ret = pjp.proceed();
        long end = System.currentTimeMillis() - begin;
        log.info("[Timer] method`execution time is " + end);
        return ret;
    }
}