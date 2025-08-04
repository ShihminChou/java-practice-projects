package com.example.spring_hello;

import com.example.spring_hello.servlet.HelloFilter;
import com.example.spring_hello.servlet.HelloListener;
import com.example.spring_hello.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ServletComponentScan // 讓SpringBoot掃描@WebServlet等註解
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 註冊Servlet程序
//    @Bean
//    public ServletRegistrationBean getServletRegistrationBean(){
//        ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet());
//        // 設置訪問路徑
//        bean.addUrlMappings("/helloServlet");
//        return bean;
//    }
//
//    // 註冊Filter程序
//    @Bean
//    public FilterRegistrationBean getFilterRegistrationBean(){
//        FilterRegistrationBean bean = new FilterRegistrationBean(new HelloFilter());
//        // 過濾器攔截路徑
//        bean.addUrlPatterns("/helloServlet");
//        return bean;
//    }
//
//    // 註冊Listener程序
//    @Bean
//    public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean(){
//        ServletListenerRegistrationBean<HelloListener> bean = new ServletListenerRegistrationBean<>(new HelloListener());
//        return bean;
//    }

}
