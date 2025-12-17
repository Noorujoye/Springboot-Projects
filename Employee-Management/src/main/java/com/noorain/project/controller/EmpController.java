package com.noorain.project.controller;

import com.noorain.project.model.Employee;
import com.noorain.project.service.EmployeeService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmpController {


    private final EmployeeService employeeService;

    @Autowired
    EmpController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // GET : ALL EMPLOYEES WILL REFLECT TO THE BROWSER
    @GetMapping("employees") // this is endpoint
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}") // this is endpoint
    public Employee readEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployeeById(id);
    }

    // POST :  EMPLOYEES WILL GET SAVED TO THE EMPLOYEE LIST
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}") // /{id} PATH VARIABLE WHICH WILL GET HIT ON URL
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id))
            return "Delete Successfully";
        return "Not fount";
    }

    @DeleteMapping("employees") // /{id} PATH VARIABLE WHICH WILL GET HIT ON URL
    public String deleteAllEmployee() {
        if (employeeService.deleteAllEmployee())
            return "Deleted All employees Successfully";
        return "employees are not found!";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id , employee);
    }
}


/*
@Autowired is optional for a class having single constructor
 */