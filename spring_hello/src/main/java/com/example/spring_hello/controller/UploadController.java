package com.example.spring_hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    Map<String, Object> result = new HashMap<String, Object>();
    /*
    接收文件
     */
    @RequestMapping("/uploadAttach")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("attach") MultipartFile file) throws IOException {
        // 處理文件
        System.out.println("文件名稱：" + file.getOriginalFilename());
        System.out.println("文件類型：" + file.getContentType());

        // 保存到
        file.transferTo(new File("/Users/shimin_zhou/Desktop/" + file.getOriginalFilename()));

        result.put("status", "success");
        return result;
    }
}
