package com.example.employeepayrollappspringboot.Entity;

import com.example.employeepayrollappspringboot.DTO.EmployeePayrollDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;
    private String employeename;
    private double salary;



    public Employee(EmployeePayrollDTO employeeDTO) {
        this.employeename = employeeDTO.getEmployeename();
        this.salary = employeeDTO.getSalary();


    }


}


