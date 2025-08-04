package com.example.spring_data.dao;

import com.example.spring_data.domin.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
