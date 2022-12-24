package com.example.mentoring.config;

import com.example.mentoring.common.CustomInterceptor;
import com.example.mentoring.common.ThreadLocalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // registry.addConverter(new StringToMenuConverter()), 스프링 부트 환경에서는 해당 구문 필요 없음
        // registry.addConverter(new LocalTimeConverter())
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(new CustomInterceptor());
        interceptorRegistry.addInterceptor(new ThreadLocalInterceptor());
    }
}