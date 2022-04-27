package com.example.demo.services;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeHigherThanAverageSalaryTest {

    @Test
    void employeeHigherThanAverageSalary() throws SQLException {
        //
        String str="2015-03-31";
        Date date=Date.valueOf(str);//converting string into sql date
        Employee joe = new Employee(420, "joe", "clown", 3213, date, 500, 600);

        EmployeeHigherThanAverageSalary employeeHigherThanAverageSalary = new EmployeeHigherThanAverageSalary();
        boolean lowerThanAvg = employeeHigherThanAverageSalary.employeeHigherThanAverageSalary(joe);
        assertFalse(lowerThanAvg);
        joe.setSalary(3000);
        boolean higherThanAvg = employeeHigherThanAverageSalary.employeeHigherThanAverageSalary(joe);
        assertTrue(higherThanAvg);
    }
}