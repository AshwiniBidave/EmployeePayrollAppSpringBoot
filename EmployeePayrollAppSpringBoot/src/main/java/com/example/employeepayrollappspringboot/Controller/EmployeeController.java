package com.example.employeepayrollappspringboot.Controller;

import com.example.employeepayrollappspringboot.DTO.EmployeePayrollDTO;
import com.example.employeepayrollappspringboot.DTO.ResponseDTO;
import com.example.employeepayrollappspringboot.Entity.Employee;
import com.example.employeepayrollappspringboot.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("EmployeePayroll")
public class EmployeeController {
    @Autowired
     private EmployeeService employeeService;
    @RequestMapping("/get")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<Employee> employeeList=employeeService.getEmployeePayrollData();
        ResponseDTO responseDTO=new ResponseDTO("Get Call Success",employeeList);
        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{EmpId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollByID(@PathVariable int EmpId){
        Employee findById=employeeService.getEmployeePayrollDataById(EmpId);
        ResponseDTO responseDTO=new ResponseDTO("Get Call Sucess by Id",findById);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/employeename/{employeename}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataForDepartment(@PathVariable("employeename") String employeename) {
        List<Employee> empDataList =employeeService.getEmployeeDataByName(employeename);
        ResponseDTO respDTO = new ResponseDTO("Get Call for employeename Successful", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> CreateEmployeePayroll(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
        Employee employeeData=employeeService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Create Employee Payroll Data Successfully",employeeData);
        return  new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @PutMapping("/update/{EmpId}")
    public ResponseEntity<ResponseDTO> UpdateEmployeePayroll(@PathVariable("EmpId") int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO){
        Employee employeeData=employeeService.updateEmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Update Employee Payroll Data Successfully",employeeData);
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{EmpId}")
    public ResponseEntity<ResponseDTO> DeleteEmployeePayroll(@PathVariable int EmpId){
        employeeService.deleteEmployeePayrollData(EmpId);
        ResponseDTO responseDTO=new ResponseDTO("Deleted successfully",+EmpId);
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


}


