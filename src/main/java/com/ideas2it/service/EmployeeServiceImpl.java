package com.ideas2it.service;

import com.ideas2it.converter.EmployeeConverter;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dateTimeUtils.DateTimeUtils;
import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.exception.EmployeeNotFoundException;
import com.ideas2it.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private DateTimeUtils dateTimeUtils;

    @Override
    public int addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.employeeDTOtoEmployee(employeeDTO);
        employee.setCreatedAt(dateTimeUtils.getDate());
        employee.setModifiedAt(dateTimeUtils.getDate());
        return employeeDao.save(employee).getEmployeeId();
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeDao.findAll();
        return employeeConverter.getEmployees(employees);
    }

    @Override
    public EmployeeDTO getEmployeeById(int employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeDao.findById(employeeId);
        EmployeeDTO employeeDTO;
        if(employee.isPresent()) {
            employeeDTO = employeeConverter.employeeToEmployeeDtTO(employee.get());
        } else {
            throw new EmployeeNotFoundException("Employee Not Found");
        }

        return employeeDTO;
    }

    @Override
    public int updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.employeeDTOtoEmployee(employeeDTO);
        employee.setModifiedAt(dateTimeUtils.getDate());
        Employee existEmployee = employeeDao.findById(employeeDTO.getEmployeeId()).get();
        employee.setCreatedAt(existEmployee.getCreatedAt());
        return employeeDao.save(employee).getEmployeeId();
    }

    public String deleteEmployee(int employeeId){
        employeeDao.deleteById(employeeId);
        return "Employee Deleted";
    }
}
