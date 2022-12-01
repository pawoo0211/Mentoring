package com.example.mentoring.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("Filter: Filter`s init method is called");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.info("Filter: Filter`s doFilter method is started");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        chain.doFilter(httpRequest, response);

        log.info("Filter: Filter`s doFilter method end");
    }

    @Override
    public void destroy() {

        log.info("Filter: Filter`s destroy method is called");
    }
}
