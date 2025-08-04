package com.example.spring_cache.service;

import com.example.spring_cache.domin.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpService {

    public List<Employee> findAll();

    public Employee findById(Integer id);

    public Page<Employee> findByPage(Pageable pageable);

    public void save(Employee employee);
}
