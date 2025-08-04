package com.example.spring_test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("role")
public class RoleController {

    @RequestMapping("/add")
    public String add(){
        // 模擬運算異常
        int i = 100 / 0;
        return "list";
    }

    @RequestMapping("/update")
    public String update(){
        // 模擬異常
        String name = null;
        name.toLowerCase();
        return "list";
    }

}
