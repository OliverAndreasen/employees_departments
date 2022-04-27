package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee>{
    @Override
    public List<Employee> getAllEntities() {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Employee> allEmployees = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees_departments.employees");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Employee temp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                allEmployees.add(temp);
            }

        }catch(SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public Employee getSingleById(int id) {
        Connection conn = DatabaseConnectionManager.getConnection();
        Employee temp = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees_departments.employees WHERE id = " + id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                 temp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                         rs.getInt(8)
                );
            }

        }catch(SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public boolean create(Employee employee) {
        Connection conn = DatabaseConnectionManager.getConnection();

        boolean result = false;
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees_departments.employees (id, employee_name, job, manager, hiredate, salary, commission, department_number) VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setInt(1,employee.getId());
            pstmt.setString(2,employee.getEmployeeName());
            pstmt.setString(3,employee.getJob());
            pstmt.setInt(4,employee.getManager());
            pstmt.setDate(5,employee.getHireDate());
            pstmt.setInt(6,employee.getSalary());
            pstmt.setInt(7,employee.getCommission());
            pstmt.setInt(8,employee.getDepartment_number());

            int row = pstmt.executeUpdate();
            result = true;
            // rows affected
            System.out.println(row); //1

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public List<Employee> getAllEntitiesFromDepartment(int department_number) {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Employee> allEmployees = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees_departments.employees INNER JOIN departments ON departments.department_number = employees.department_number WHERE employees.department_number =" + department_number);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Employee temp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                allEmployees.add(temp);
            }

        }catch(SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return allEmployees;
    }


}
