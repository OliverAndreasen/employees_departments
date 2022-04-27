package com.example.demo.services;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAndDepartmentValidationTest {

    @Test
    void validateEmployeeCommission() {
        String str="2015-03-31";
        Date date=Date.valueOf(str);//converting string into sql date

        Employee joe = new Employee(420, "joe", "clown", 3213, date, 500, 600);
        EmployeeAndDepartmentValidation employeeAndDepartmentValidation = new EmployeeAndDepartmentValidation();

        boolean tooHigh = employeeAndDepartmentValidation.validateEmployeeCommission(joe);
        assertFalse(tooHigh);

        joe.setCommission(400);
        boolean valid = employeeAndDepartmentValidation.validateEmployeeCommission(joe);
        assertTrue(valid);




    }
}