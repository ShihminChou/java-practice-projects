package com.example.spring_test.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class MySimpleMappingExceptionResolver {


    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();

        // 參數1:異常類型 一定要全名
        // 參數2:頁面名稱
        mappings.put("java.lang.ArithmeticException", "error1");
        mappings.put("java.lang.NullPointerException", "error2");

        // 設置異常顯示訊息
        // 哪些異常要交給哪個錯誤頁面顯示
        resolver.setExceptionMappings(mappings);

        return  resolver;
    }
}
