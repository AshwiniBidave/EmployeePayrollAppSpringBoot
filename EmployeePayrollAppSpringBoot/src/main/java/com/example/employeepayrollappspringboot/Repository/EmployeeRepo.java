package com.example.employeepayrollappspringboot.Repository;

import com.example.employeepayrollappspringboot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


}
