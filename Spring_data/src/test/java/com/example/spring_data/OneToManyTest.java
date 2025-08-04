package com.example.spring_data;

import com.example.spring_data.dao.EmployeeRepository;
import com.example.spring_data.domin.Dept;
import com.example.spring_data.domin.Employee;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataApplication.class)
public class OneToManyTest {

    @Resource
    private EmployeeRepository employeeRepository;

    // 新增
    @Test
    public void testSave(){

        // 創建部門
        Dept dept = new Dept();
        dept.setDeptName("財務部");

        // 創建員工
        Employee employee = new Employee();
        employee.setName("小明");

        // 關聯
        dept.getEmployees().add(employee);
        employee.setDept(dept);

        // 保存資料
        employeeRepository.save(employee);

    }

    // 查詢
    @Test
    public void testFind() {
        // 查詢員工
        Employee employee = employeeRepository.findById(6)
                .orElseThrow(() -> new RuntimeException("找不到 ID 為 6 的員工"));

        // 所在部門
        Dept dept = employee.getDept();
        System.out.println("員工 " + employee.getName() + " 的部門是 " + dept.getDeptName());
    }

}
