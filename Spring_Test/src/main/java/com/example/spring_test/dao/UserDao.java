package com.example.spring_test.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void save(){
        System.out.println("UserDao save");
    }
}
