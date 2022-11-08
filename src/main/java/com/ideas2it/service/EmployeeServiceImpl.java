package com.ideas2it.service;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dateTimeUtils.DateTimeUtils;
import com.ideas2it.exception.EmployeeNotFoundException;
import com.ideas2it.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    DateTimeUtils dateTimeUtils = new DateTimeUtils();
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setCreatedAt(dateTimeUtils.getDate());
        employee.setModifiedAt(dateTimeUtils.getDate());
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeDao.findById(employeeId);
        if(!employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return employee.get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    public String deleteEmployee(int employeeId){
        employeeDao.deleteById(employeeId);
        return "Employee Deleted";
    }
}
