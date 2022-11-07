package com.ideas2it.service;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dateTimeUtils.DateTimeUtils;
import com.ideas2it.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public Employee getEmployeeById(int employeeId) {
        return employeeDao.findById(employeeId).get();
    }

    @Override
    public Employee updateEmployee(int employeeId,Employee updatedEmployee) {
       Employee employee = employeeDao.findById(employeeId).get();

        if(Objects.nonNull(updatedEmployee.getEmployeeType()) && !"".equals(updatedEmployee.getEmployeeType())) {
            employee.setEmployeeType(updatedEmployee.getEmployeeType());
        }

        if(Objects.nonNull(updatedEmployee.getName()) && !"".equals(updatedEmployee.getName())) {
            employee.setName(updatedEmployee.getName());
        }

        if(Objects.nonNull(updatedEmployee.getMobileNumber()) && !"".equals(updatedEmployee.getMobileNumber())) {
            employee.setMobileNumber(updatedEmployee.getMobileNumber());
        }

        if(Objects.nonNull(updatedEmployee.getEmailId()) && !"".equals(updatedEmployee.getEmailId())) {
            employee.setEmailId(updatedEmployee.getEmailId());
        }

        if(Objects.nonNull(updatedEmployee.getDateOfBirth()) && !"".equals(updatedEmployee.getDateOfBirth())) {
            employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        }

        if(Objects.nonNull(updatedEmployee.getDesignation()) && !"".equals(updatedEmployee.getDesignation())) {
            employee.setDesignation(updatedEmployee.getDesignation());
        }

        if(Objects.nonNull(updatedEmployee.getGender()) && !"".equals(updatedEmployee.getGender())) {
            employee.setGender(updatedEmployee.getGender());
        }

        employee.setModifiedAt(dateTimeUtils.getDate());
        return employeeDao.save(employee);
    }

    public String deleteEmployee(int employeeId){
        employeeDao.deleteById(employeeId);
        return "Employee Deleted";
    }
}
