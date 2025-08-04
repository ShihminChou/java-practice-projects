package com.example.spring_cache;

import com.example.spring_cache.domin.Employee;
import com.example.spring_cache.service.EmpService;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCacheApplication.class)
public class EmpServiceTest {

    @Resource
    private EmpService empService;

    @Test
    public void testFindById() {
        // 查詢第一次
        System.out.println(empService.findById(1));
        // 查詢第二次
        System.out.println(empService.findById(1));
    }

    @Test
    public void testFindByPage() {
        Pageable pageable = PageRequest.of(0, 2);
        // 查詢第一次
        System.out.println(empService.findByPage(pageable).getTotalElements());
        // 查詢第二次
        System.out.println(empService.findByPage(pageable).getTotalElements());

        pageable = PageRequest.of(1, 2); // 換頁
        System.out.println(empService.findByPage(pageable).getTotalElements());
    }

    @Test
    public void testFindAll() {
        // 查詢第一次
        System.out.println(empService.findAll().size());

        // 新增
        Employee employee = new Employee();
        employee.setName("Kelly");
        empService.save(employee);

        // 查詢第二次
        System.out.println(empService.findAll().size());
    }

}
