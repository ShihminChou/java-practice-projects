package com.example.spring_test.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class User {
    private Integer id;
    @NotBlank(message = "用戶名不能為空") // 必填/非空
    private String user;
    @NotBlank(message = "密碼不能為空")
    @Length(min = 4, max = 10, message = "密碼必須要輸入4-10位")
    private String password;
    @Min(value = 0)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
