package com.example.spring_cache.service.impl;

import com.example.spring_cache.dao.EmployeeRepository;
import com.example.spring_cache.domin.Employee;
import com.example.spring_cache.service.EmpService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    @Cacheable(value = "emp")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Cacheable(value = "emp") // @Cacheable:把當前方法的返回值放入緩存, value:緩存配置的名稱
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }


    @Override
    @Cacheable(value = "emp", key = "#pageable.pageSize") // 如果不寫key的話 默認就是對象名稱(pageable)，在pageable不變的情況下就會緩存資料，如果是設定#pageable.pageSize的話，在
    public Page<Employee> findByPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    @CacheEvict(value = "emp", allEntries = true)
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
