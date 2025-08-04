package com.example.spring_test.service;

import com.example.spring_test.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public void save(){
        userDao.save();
    }
}
