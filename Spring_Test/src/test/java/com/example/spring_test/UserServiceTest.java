package com.example.spring_test;

import com.example.spring_test.service.UserService;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// RunWith: 讓junit和Spring環境進行整合
// SpringBootTest: 該類是一個SpringBoot測試類，加載SpringBoot啟動器類
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringTestApplication.class})
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testSave(){
        userService.save();
    }
}
