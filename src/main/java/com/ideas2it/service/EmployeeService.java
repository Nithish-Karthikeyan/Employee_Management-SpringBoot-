package com.ideas2it.service;

import com.ideas2it.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public List<Employee> getEmployees();

    public Employee getEmployeeById(int employeeId);

    public Employee updateEmployee(int employeeId, Employee employee);

    public String deleteEmployee(int employeeId);
}
