package com.example.employeepayrollappspringboot.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeePayrollDTO {
    @NotBlank(message = "Please enter proper employee name")
    @Pattern(regexp="^[A-Z][a-z A-Z]{2,}$")
    private String employeename;

    @NotNull(message = "Please enter a valid salary")
    @Min(value=1000, message = "Salary must be atleast 1000.00")
    @Max(value=40000, message = "Salary should not be greater than 40000.00")
    private double salary;
    @NotEmpty(message = "Input department list cannot be empty.")
    private List<String> department;

    @NotBlank(message = "please enter proper mobile number")
    @Pattern(regexp ="^(91){1}[ ]+[0-9]{10}$")
    private String mobileNumber;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy",shape =JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @NotNull(message = "notes should not be empty")
    private String notes;

}
