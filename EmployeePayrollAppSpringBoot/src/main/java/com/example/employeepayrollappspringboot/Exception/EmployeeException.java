package com.example.employeepayrollappspringboot.Exception;

public class EmployeeException extends  RuntimeException{
    public EmployeeException() {
    }

    public EmployeeException(String message) {
        super(message);
    }
}
