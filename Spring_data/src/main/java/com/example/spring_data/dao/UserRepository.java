package com.example.spring_data.dao;

import com.example.spring_data.domin.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
