package com.example.demo.services;

import com.example.demo.models.Employee;

public class EmployeeAndDepartmentValidation {
    public boolean validateEmployeeCommission(Employee employee){

        if(employee.getCommission() < employee.getSalary()){
            return true;
        }
        return false;
    }
}
