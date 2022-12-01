package com.example.mentoring.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 동기 "Interceptor" -> "HandlerInterceptor"
 * 비동기 "Interceptor" -> "AsyncHandlerInterceptor"
 */
@Slf4j
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse Response, Object handler)
            throws Exception {

        log.info("Interceptor: Interceptor`s preHandle method is called");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

        log.info("Interceptor: Interceptor`s postHandle method is called");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

        log.info("Interceptor : Interceptor`s afterCompletion method is called");
    }
}