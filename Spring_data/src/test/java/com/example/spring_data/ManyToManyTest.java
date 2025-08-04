package com.example.spring_data;

import com.example.spring_data.dao.RoleRepository;
import com.example.spring_data.dao.UserRepository;
import com.example.spring_data.domin.Role;
import com.example.spring_data.domin.User;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataApplication.class)
public class ManyToManyTest {

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;

    @Test
    public void testSave(){

        // 新增User
        User user = new User();
        user.setName("Eric");
        user.setPassword("123456");

        // 新增role
        Role role = new Role();
        role.setName("超級管理員");

        Role role2 = new Role();
        role2.setName("普通管理員");

        // 關聯
        user.getRoles().add(role);
        user.getRoles().add(role2);
        role.getUsers().add(user);
        role2.getUsers().add(user);

        // 保存資料
        userRepository.save(user);
    }

    // 查詢
    @Test
    public void testFind(){
        User user = userRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("找不到 ID 為 1 的角色"));;
        Set<Role> roles = user.getRoles();
        System.out.println("User " + user.getName() + "的角色為 ");
        for (Role role : roles) {
            System.out.println(role.getName());
        }
    }

    @Test
    public void testDelete(){
        roleRepository.deleteAll();
    }
}
