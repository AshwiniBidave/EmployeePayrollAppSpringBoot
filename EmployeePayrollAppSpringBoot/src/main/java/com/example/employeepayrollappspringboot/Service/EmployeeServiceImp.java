package com.example.employeepayrollappspringboot.Service;

import com.example.employeepayrollappspringboot.DTO.EmployeePayrollDTO;
import com.example.employeepayrollappspringboot.Entity.Employee;

import java.util.List;

public interface EmployeeServiceImp {
    List<Employee> getEmployeePayrollData();
    Employee getEmployeePayrollDataById(int EmpId);
    Employee createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
    Employee updateEmployeePayrollData(int EmpId,EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int EmpId);

}
