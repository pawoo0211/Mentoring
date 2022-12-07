package com.example.mentoring.common;

import com.example.mentoring.common.threadlocal.ThreadLocalContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ThreadLocalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("ThreadInterceptor: Interceptor`s preHandle method is called");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
        log.info("ThreadInterceptor: Interceptor`s postHandle method is called");
        ThreadLocalContextHolder.reset();
    }

}
