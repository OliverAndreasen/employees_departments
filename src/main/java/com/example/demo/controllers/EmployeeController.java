package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class EmployeeController {
    private final IRepository<Employee> employeeRepository = new EmployeeRepository();

    @GetMapping("/employees")
    public String allEmployees(Model model){
        model.addAttribute("employees", employeeRepository.getAllEntities());
        return "employees";
    }

    @GetMapping("/employee")
    public String getEmployee(@RequestParam int id, Model model) {
        model.addAttribute("employees", employeeRepository.getSingleById(id));
        System.out.println(employeeRepository.getSingleById(id));
        return "employee";
    }

    @GetMapping("/addEmployee")
    public String employeeForm(Model model) {
        ArrayList<String> employee = new ArrayList<>();
        model.addAttribute("employee", new Employee(0, null, null, 0,null,0,0,0));
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String greetingSubmit(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("employee", employee);
        employeeRepository.create(employee);
        return "employees";
    }


    @GetMapping("/employeesfromdepartment")
    public String getEmployeesFromDepartment(@RequestParam int id, Model model) {
        model.addAttribute("employees", employeeRepository.getAllEntitiesFromDepartment(id));
        return "employeesfromdepartment";
    }


}
