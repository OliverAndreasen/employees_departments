package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeHigherThanAverageSalary {
    public boolean employeeHigherThanAverageSalary(Employee employee) throws SQLException {

        if(employee.getSalary() > averageSalary()){
            return true;
        }
        return false;
    }

    public int averageSalary() throws SQLException {
        Connection conn = DatabaseConnectionManager.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT AVG(salary) FROM employees_departments.employees");
        ResultSet rs = pstmt.executeQuery();
        int avgSalary = -1;
        while(rs.next()){
            avgSalary = rs.getInt(1);
        }
        return avgSalary;
    }


    public static void main(String[] args) throws SQLException {
        EmployeeHigherThanAverageSalary employeeHigherThanAverageSalary = new EmployeeHigherThanAverageSalary();
        int avg = employeeHigherThanAverageSalary.averageSalary();
    }

}
