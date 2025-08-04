package com.example.spring_data;

import com.example.spring_data.dao.EmployeeRepository;
import com.example.spring_data.domin.Employee;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringDataApplication.class)
public class EmployeeRepositoryTest {

    @Resource
    private EmployeeRepository employeeRepository;

//    @Test
//    public void testSave() {
//        Employee employee = new Employee();
//        employee.setName("Cherry");
//        employee.setGender("Female");
//        employee.setTelephone("1134567888");
//        employee.setAddress("Osaka");
//
//        employeeRepository.save(employee);
//    }

    @Test
    public void testFindByName() {
        List<Employee> list = employeeRepository.findByName("Andy");

        for(Employee employee : list){
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameAndGender() {
        List<Employee> list = employeeRepository.findByNameAndGender("James", "Male");

        for(Employee employee : list){
            System.out.println(employee);
        }
    }

    // 如果是Like(模糊查詢)的話，需要加上關鍵符號
    // %: 匹配任一字符
    // _: 匹配一個字符
    @Test
    public void testFindByTelephoneLike() {
        List<Employee> list = employeeRepository.findByTelephoneLike("%1234%");

        for(Employee employee : list){
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryName() {
        List<Employee> list = employeeRepository.queryName("Cherry");

        for(Employee employee : list){
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryName2() {
        List<Employee> list = employeeRepository.queryName2("Cherry");

        for(Employee employee : list){
            System.out.println(employee);
        }
    }


    @Test // @Transactional和@Test一起使用的時候，事務會自動回滾
    @Transactional // 可以加在方法、類別或測試類上，用來保證更新操作在一個交易中完成
    @Rollback(false) // 取消自動回滾
    public void testUpdateAddressById() {
        employeeRepository.updateAddressById("Osaka", 2);
    }

    // 新增
    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("Jenny");
        employee.setGender("Female");
        employee.setTelephone("1234567799");
        employee.setAddress("Tokyo");

        employeeRepository.save(employee);
    }

    // 修改
    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("Jenny");
        employee.setGender("Female");
        employee.setTelephone("1234567799");
        employee.setAddress("Kobe");

        employeeRepository.save(employee);
    }

    // 查詢所有資料
    @Test
    public void testFindAll(){
        employeeRepository.findAll().forEach(System.out::println);
    }

    // 查詢單筆資料
    @Test
    public void testFindById(){
        Optional<Employee> employee = employeeRepository.findById(4);
        System.out.println(employee);
    }

    // 刪除單筆資料
    @Test
    public void testDeleteById(){
        employeeRepository.deleteById(4);
    }

    // 排序
    @Test
    public void testSort(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Iterable<Employee> list = employeeRepository.findAll(sort);
        for(Employee employee : list){
            System.out.println(employee);
        }
    }

    //　分頁
    @Test
    public void testPageable(){
        // Pageable:用於封裝分頁參數 當前頁碼和查詢紀錄數(注意:當前頁碼從0開始)
        Pageable pageable = PageRequest.of(1, 2);
        // Page:用於封裝分頁查詢後的結果
        Page<Employee> pageData = employeeRepository.findAll(pageable);

        System.out.println("總紀錄數：" + pageData.getTotalElements());
        List<Employee> list = pageData.getContent();
        for(Employee employee : list){
            System.out.println(employee);
        }
        System.out.println("總頁數:"+pageData.getTotalPages());
    }

    //　排序 + 分頁
    @Test
    public void testSortAndPageable(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        // Pageable:用於封裝分頁參數 當前頁碼和查詢紀錄數(注意:當前頁碼從0開始)
        Pageable pageable = PageRequest.of(0, 2, sort);
        // Page:用於封裝分頁查詢後的結果
        Page<Employee> pageData = employeeRepository.findAll(pageable);

        System.out.println("總紀錄數：" + pageData.getTotalElements());
        List<Employee> list = pageData.getContent();
        for(Employee employee : list){
            System.out.println(employee);
        }
        System.out.println("總頁數:"+pageData.getTotalPages());
    }

    //　使用JpaSpecificationExecutor接口的方法(一個條件)
    @Test
    public void testFindAllJpaSpecificationExecutor1(){
        // Specification:封裝條件數據的對象
        Specification<Employee> specification = new Specification<Employee>() {
            /*
             *  Predicate: 條件（判斷式），回傳的 Predicate 可以是單一條件，也可以是多個條件的組合（例如 AND / OR）
             *  root: 根資料模型, 查詢的主表對象。代表的是你要查的資料類別，例如這裡的 Employee，可以透過它取得實體的欄位（例如 name、address 等）來建立條件。
             *  CriteriaQuery: 代表整個查詢語句。用來設定查詢的結構，例如：是否要 distinct()、排序（orderBy()）、select() 等。
             *  CriteriaBuilder: 查詢條件構造器，用於完成不同條件的查詢。它是用來建立條件（Predicate）或其他 SQL 結構的工具。
             */
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // where = ?
                // 參數1: 查詢的屬性(需要使用root進行查詢)
                // 參數2: 條件值
                Predicate predicate = criteriaBuilder.equal(root.get("name"), "Andy");

                return predicate;
            }
        };

        List<Employee> list = employeeRepository.findAll(specification);
        for(Employee employee : list){
            System.out.println(employee);
        }
    }

    //　使用JpaSpecificationExecutor接口的方法(多個條件)
    @Test
    public void testFindAllJpaSpecificationExecutor2(){
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // where name =? and gender =?
                List<Predicate> preList = new ArrayList<>();
                preList.add(criteriaBuilder.equal(root.get("name"), "Jenny"));
                preList.add(criteriaBuilder.equal(root.get("gender"), "Female"));

                Predicate[] preArr = new Predicate[preList.size()];
                return criteriaBuilder.and(preList.toArray(preArr));
            }
        };

        List<Employee> list = employeeRepository.findAll(specification);
        for(Employee employee : list){
            System.out.println(employee);
        }
    }

}
