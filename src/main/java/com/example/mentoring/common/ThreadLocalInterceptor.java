package com.example.mentoring.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ThreadLocalInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<HttpServletRequest> httpRequestThread = new ThreadLocal<>();
    private static final ThreadLocal<HttpServletResponse> httpResponseThread = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        log.info("ThreadInterceptor: Interceptor`s preHandle method is called");
        httpRequestThread.set(request);
        httpResponseThread.set(response);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

        log.info("ThreadInterceptor: Interceptor`s postHandle method is called");
        log.info("Request`s URI: " + httpRequestThread.get().getRequestURI());
        log.info("Response`s Status: " + httpResponseThread.get().getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

        log.info("ThreadInterceptor: Interceptor`s afterCompletion method is called");
        httpRequestThread.remove();
        httpResponseThread.remove();
    }
}
