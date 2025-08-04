package com.example.spring_hello.controller;

import com.example.spring_hello.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    // 用戶列表展示
    @RequestMapping("/list")
    public String list(Model model){
        // 模擬用戶資料
        List<User> list = new ArrayList<User>();
        list.add(new User(1, "Andy", 18));
        list.add(new User(2, "May", 20));
        list.add(new User(3, "Gery", 22));

        // 把資料存到Model
        model.addAttribute("list", list);

        // 跳轉到freemarker頁面: list.ftl
        return "list";
    }

}
