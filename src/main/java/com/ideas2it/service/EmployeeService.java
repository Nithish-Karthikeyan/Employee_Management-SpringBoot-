package com.ideas2it.service;

import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    public int addEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> getEmployees();

    public EmployeeDTO getEmployeeById(int employeeId) throws EmployeeNotFoundException;

    public int updateEmployee(EmployeeDTO employeeDTO);

    public String deleteEmployee(int employeeId);
}
