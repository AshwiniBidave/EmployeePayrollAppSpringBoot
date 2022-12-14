package com.example.employeepayrollappspringboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeePayrollDTO {
    private String employeename;

    private double salary;
}
