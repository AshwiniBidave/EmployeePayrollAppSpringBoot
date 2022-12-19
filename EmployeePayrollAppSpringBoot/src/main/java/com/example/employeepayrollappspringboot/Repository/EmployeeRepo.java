package com.example.employeepayrollappspringboot.Repository;

import com.example.employeepayrollappspringboot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

@Query(value = "select  * from Employee e where  e.employeename=employeename",nativeQuery = true)
    List<Employee> findByname(String employeename);
}
