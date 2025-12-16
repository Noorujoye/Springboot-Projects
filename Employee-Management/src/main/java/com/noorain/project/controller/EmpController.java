package com.noorain.project.controller;

import com.noorain.project.model.Employee;
import com.noorain.project.service.EmployeeService;
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
}


/*
@Autowired is optional for a class having single constructor
 */