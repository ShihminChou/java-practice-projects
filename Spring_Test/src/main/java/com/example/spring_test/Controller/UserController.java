package com.example.spring_test.Controller;

import com.example.spring_test.domain.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    // 跳轉到list
//    @RequestMapping("/list")
//    public String list(){
//        System.out.println("run list...");
//        return "list";
//    }

    // 跳轉到add.html
    @RequestMapping("toAdd")
    public String toAdd(User user){
        return "add";
    }

    // User add
    // BindingResult: 用於封裝驗證對象(user) 裡面得驗證結果
    @RequestMapping("add")
    public String add(@Valid User user, BindingResult result){

        // 如果存在驗證錯誤
        if(result.hasErrors()){
            // 返回add.html
            return "add";
        }

        System.out.println("保存用戶："+ user);
        return "success";
    }

}
