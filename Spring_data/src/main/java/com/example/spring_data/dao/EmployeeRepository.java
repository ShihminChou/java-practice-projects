package com.example.spring_data.dao;

import com.example.spring_data.domin.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


import java.util.List;

// 參數1:需要映射的實體
// 參數2:實體裡面的OID類型
//public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//
//}

// Repository<T, ID>
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

    // 查詢name(駝峰式命名)
    List<Employee> findByName(String name);
    List<Employee> findByNameAndGender(String name, String gender);
    List<Employee> findByTelephoneLike(String telephone);

    @Query("from Employee where name = :name")
    List<Employee> queryName(@Param("name") String name);

    @Query(value="select * from t_emp where name = ? ",  nativeQuery = true)
    List<Employee> queryName2(@Param("name") String name);

    @Query("update Employee set address = :address where id = :id")
    @Modifying // 進行修改操作
    void updateAddressById(@Param("address") String address, @Param("id") Integer id);
}


