package com.example.employee.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.employee.models.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployee() {
        String sql = "select * from employee";

        return this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            List<Employee> employeeList = new ArrayList<Employee>();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("address"));
                employee.setFamily_details(rs.getString("family_details"));
                employee.setContact_number(rs.getInt("contact_number"));
                employee.setSalary_scale_id(rs.getInt("salary_scale_id"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setSupervisor_id(rs.getInt("supervisor_id"));
                employeeList.add(employee);
            }

            return employeeList;
        });

    } // getAllEmployee()

    public Employee getEmployeeById(String id) {
        return this.jdbcTemplate.queryForObject("select * from employee where id=?", new Object[] { id },
                (ResultSet rs, int rowNum) -> {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setAddress(rs.getString("address"));
                    employee.setFamily_details(rs.getString("family_details"));
                    employee.setContact_number(rs.getInt("contact_number"));
                    employee.setSalary_scale_id(rs.getInt("salary_scale_id"));
                    employee.setDepartment_id(rs.getInt("department_id"));
                    employee.setSupervisor_id(rs.getInt("supervisor_id"));
                    return employee;
                });
    } // getEmployeeById()

    public int addEmployee(Employee employee) {
        return this.jdbcTemplate.update(
                "insert into employee((id, name, email,address,contact_number,family_details,department_id,supervisor_id,salary_scale_id)"
                        + "values( ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[] { employee.getId(), employee.getName(), employee.getEmail(), employee.getAddress(),
                        employee.getContact_number(), employee.getFamily_details(), employee.getDepartment_id(),
                        employee.getSupervisor_id(), employee.getSalary_scale_id() });
    } // addEmployee()

    public int updateEmployee(String id, Employee employee) {
        String sql = "update employee set "
                + "name= ?,email= ?,address= ?,contact_number= ?,family_details= ?,department_id= ?,supervisor_id= ?,salary_scale_id= ?"
                + " where id=" + id;
        return this.jdbcTemplate.update(sql,
                new Object[] { employee.getName(), employee.getEmail(), employee.getAddress(),
                        employee.getContact_number(), employee.getFamily_details(), employee.getDepartment_id(),
                        employee.getSupervisor_id(), employee.getSalary_scale_id() });
    } // updateEmployee()

    public int deleteEmployeeById(String id) {
        String deleteSql = "delete from employee where id=" + id;
        return this.jdbcTemplate.update(deleteSql, new Object[] { id });
    } // deleteEmployeeById()
} // class