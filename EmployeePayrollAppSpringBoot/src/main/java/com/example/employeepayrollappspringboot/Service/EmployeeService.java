package com.example.employeepayrollappspringboot.Service;
import com.example.employeepayrollappspringboot.Entity.Employee;
import com.example.employeepayrollappspringboot.DTO.EmployeePayrollDTO;
import com.example.employeepayrollappspringboot.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements EmployeeServiceImp{

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getEmployeePayrollData() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeePayrollDataById(int EmpId) {

        return employeeRepo.findById(EmpId).get();
    }

    @Override
    public Employee createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        Employee employee = new Employee(empPayrollDTO);
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployeePayrollData(int EmpId,EmployeePayrollDTO empPayrollDTO) {

        Employee employee=new Employee(empPayrollDTO);
        employee.setEmployeeid(EmpId);


        return employeeRepo.save(employee);

    }

    @Override
    public void deleteEmployeePayrollData(int EmpId) {
        employeeRepo.deleteById(EmpId);
    }

    @Override
    public List<Employee> getEmployeeDataByName(String employeename) {
        return employeeRepo.findByname(employeename);
    }
}
