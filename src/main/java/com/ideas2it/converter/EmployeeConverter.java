package com.ideas2it.converter;

import com.ideas2it.dateTimeUtils.DateTimeUtils;
import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeConverter {

    @Autowired
    private DateTimeUtils dateTimeUtils;
    public Employee employeeDTOtoEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setEmployeeType(employeeDTO.getEmployeeType());
        employee.setName(employeeDTO.getName());
        employee.setEmailId(employeeDTO.getEmailId());
        employee.setGender(employeeDTO.getGender());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setMobileNumber(employeeDTO.getMobileNumber());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setCreatedAt(dateTimeUtils.getDate());
        employee.setModifiedAt(dateTimeUtils.getDate());
        return employee;
    }

    public EmployeeDTO employeeToEmployeeDtTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setEmployeeType(employee.getEmployeeType());
        employeeDTO.setName(employee.getName());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setDesignation(employee.getDesignation());
        employeeDTO.setEmailId(employee.getEmailId());
        employeeDTO.setMobileNumber(employee.getMobileNumber());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        return employeeDTO;
    }

    public List<EmployeeDTO> getEmployees(List<Employee> employees) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Employee employee : employees) {
            employeeDTOList.add(employeeToEmployeeDtTO(employee));
        }
        return employeeDTOList;
    }
}

