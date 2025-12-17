package com.noorain.project.service;

import com.noorain.project.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    String createEmployee(Employee employee); // return type is Employee to return employees
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id , Employee employee);
    Employee readEmployeeById(Long id);
    boolean deleteAllEmployee();
}
