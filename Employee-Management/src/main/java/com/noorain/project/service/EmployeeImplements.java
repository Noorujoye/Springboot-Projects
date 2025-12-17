package com.noorain.project.service;

import com.noorain.project.model.Employee;
import com.noorain.project.repository.EmployeeEntity;
import com.noorain.project.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeImplements implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity); // copying the model to EmployeeEntity
        employeeRepository.save(employeeEntity);
        //employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeList) {

            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public Employee readEmployeeById(Long id) {
       EmployeeEntity employeeEntity = employeeRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Employee not found for id: " + id));
       Employee employee = new Employee();
       BeanUtils.copyProperties(employeeEntity,employee);
       return employee;
    }

    // delete by id
    public boolean deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete: Employee " + id + " not found.");
        }
            employeeRepository.deleteById(id);
            return true;
    }

    // delete all
    public boolean deleteAllEmployee() {
        employeeRepository.deleteAll();
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Update fail: " + id + " not found."));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());

        // No need to call .save() explicitly if @Transactional is working,
        // but keeping it for clarity in our current flow.
        employeeRepository.save(existingEmployee);
        return "update Successfully";
    }
}
