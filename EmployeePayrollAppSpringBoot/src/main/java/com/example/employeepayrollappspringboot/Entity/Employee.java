package com.example.employeepayrollappspringboot.Entity;

import com.example.employeepayrollappspringboot.DTO.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;
    private String employeename;
    private double salary;
    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;
    private String mobileNumber;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy",shape =JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    private String notes;


    public Employee(EmployeePayrollDTO employeeDTO) {
        this.employeename = employeeDTO.getEmployeename();
        this.salary = employeeDTO.getSalary();
        this.department=employeeDTO.getDepartment();
        this.startDate=employeeDTO.getStartDate();
        this.mobileNumber=employeeDTO.getMobileNumber();
        this.notes=employeeDTO.getNotes();

    }


}


