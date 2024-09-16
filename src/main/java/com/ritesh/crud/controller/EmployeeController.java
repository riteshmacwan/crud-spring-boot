package com.ritesh.crud.controller;

import com.ritesh.crud.model.Employee;
import com.ritesh.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.fetchAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.orElse(null);
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long id, Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        boolean isEmployeeDeleted = employeeService.deleteEmployee(id);
        System.out.println("isEmployeeDeleted::" + isEmployeeDeleted);
        if (!isEmployeeDeleted) {
            return "Employee deleted!";
        }
        return "Something Went wrong";
    }
}
