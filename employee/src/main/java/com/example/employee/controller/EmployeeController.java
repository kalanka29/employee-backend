package com.example.employee.controller;

import java.util.List;

import com.example.employee.models.Employee;
import com.example.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return this.employeeService.findAllEmployees();
    } // findAllEmployees()

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
      return this.employeeService.getEmployeeById(id);
    } // getEmployeeById()

    @PostMapping("/employee")
    public int addEmployee(@RequestBody final Employee employee) {
      return this.employeeService.addEmployee(employee);
    } // addEmployee()
  
    @PutMapping("/employee/{id}")
    public int updateEmployee(@PathVariable final String id, @RequestBody final Employee employee) {
      return this.employeeService.updateEmployee(id, employee);
    } // updateEmployee()
  
    @DeleteMapping("/employee/{id}")
    public int deleteEmployeeById(@PathVariable final String id) {
      return this.employeeService.deleteEmployeeById(id);
    } // deleteEmployeeById()

} // class