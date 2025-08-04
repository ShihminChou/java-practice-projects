package com.example.spring_hello.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "helloFilter", urlPatterns = "/helloServlet")
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("執行前面的code");

        // 放行執行目標資源
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("執行後面的code");
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
