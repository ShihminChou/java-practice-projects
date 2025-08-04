package com.example.spring_test.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 處理java.lang.ArithmeticException
    @ExceptionHandler(value={java.lang.ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception e) { // e: 包含錯誤訊息

        // 設置錯誤訊息
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e.toString());
        mv.setViewName("error1");
        return mv;
    }
    // 處理java.lang.NullPointerException
    @ExceptionHandler(value={java.lang.NullPointerException.class})
    public ModelAndView handlerNullPointerException(Exception e) { // e: 包含錯誤訊息

        // 設置錯誤訊息
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e.toString());
        mv.setViewName("error2");
        return mv;
    }
}
