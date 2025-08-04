package com.example.spring_hello.controller;

import com.example.spring_hello.domain.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController2 {

    @RequestMapping("/demo1")
    public String demo1(Model model){
        model.addAttribute("message", "Hello, Thymeleaf");
        // 跳轉到templates/demo1.html
        return "demo1";
    }

    // 變量輸出
    @RequestMapping("/demo2")
    public String demo2(Model model){
        model.addAttribute("name", "Andy");
        return "demo2";
    }

    // 條件判斷
    @RequestMapping("/demo3")
    public  String demo3(Model model){
        model.addAttribute("gender", "female");

        model.addAttribute("grade", 2);

        return "demo2";
    }

    // 迭代遍歷
    @RequestMapping("/demo4")
    public  String demo4(Model model){
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Eric", 20));
        list.add(new User(2, "Jack", 25));
        list.add(new User(3, "James", 35));
        model.addAttribute("list", list);

        return "demo2";
    }

    // 域對象的獲取
    @RequestMapping("/demo5")
    public String demo5(HttpServletRequest request, Model model) {
        // 寫入資料（模擬別人事先塞好的）
        request.setAttribute("request", "這是 request 裡的資料");
        request.getSession().setAttribute("session", "這是 session 裡的資料");
        request.getServletContext().setAttribute("application", "這是 application 裡的資料");

        // 真正取得域對象中的值
        Object reqData = request.getAttribute("request");
        Object sessData = request.getSession().getAttribute("session");
        Object appData = request.getServletContext().getAttribute("application");

        // 放入 model 給 Thymeleaf 使用
        model.addAttribute("requestData", reqData);
        model.addAttribute("sessionData", sessData);
        model.addAttribute("applicationData", appData);

        return "demo2";
    }

}
