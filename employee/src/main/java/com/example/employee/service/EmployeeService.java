package com.example.employee.service;

import java.util.List;

import com.example.employee.models.Employee;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
 
    public List<Employee> findAllEmployees() {
       return this.employeeRepository.getAllEmployee();
    } // findAllEmployees()
 
    public int addEmployee(Employee employee) {
       return this.employeeRepository.addEmployee(employee);
    } // addEmployee()
 
    public int updateEmployee(String id, Employee employee) {
       return this.employeeRepository.updateEmployee(id,employee);
    } // updateEmployee()
 
    public int deleteEmployeeById(String id) {
       return this.employeeRepository.deleteEmployeeById(id);
    } // deleteEmployeeById()
 
    public Employee getEmployeeById(String id) {
       return this.employeeRepository.getEmployeeById(id);
    } // getEmployeeById()
}