package com.example.spring_hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController // 代替@Controller + @ResponseBody
public class HelloController {

    private Map<String, Object> result = new HashMap<String, Object>();

    @RequestMapping("/hello")
//    @ResponseBody
    public Map<String, Object> hello() {
        result.put("name", "Eric");
        result.put("gender", "男");
        return result;
   }
}
