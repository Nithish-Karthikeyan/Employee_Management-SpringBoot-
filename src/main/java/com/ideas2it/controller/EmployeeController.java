package com.ideas2it.controller;

import com.ideas2it.exception.EmployeeNotFoundException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.LeaveRecords;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.LeaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveRecordService leaveRecordService;

    @GetMapping("/")
    public String getIndex() {
        return "Welcome to Employee Management Application";
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int employeeId) throws EmployeeNotFoundException {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

    @PostMapping("/addLeaveRecord/{employeeId}")
    public LeaveRecords addLeaveRecord(@PathVariable int employeeId, LeaveRecords leaveRecord) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        leaveRecord.setEmployee(employee);
        return leaveRecordService.addLeaveRecord(leaveRecord);
    }

    @GetMapping("/getLeaveRecordsByEmployeeId/{employeeId}")
    public List<LeaveRecords> getLeaveRecordsByEmployeeId(@PathVariable int employeeId) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return leaveRecordService.getLeaveRecords(employee);
    }

    @GetMapping("/getAllLeaveRecords")
    public List<LeaveRecords> getAllLeaveRecords() {
        return leaveRecordService.getAllLeaveRecords();
    }

    @DeleteMapping("/deleteLeaveRecord/{leaveId}")
    public String deleteLeaveRecord(@PathVariable int leaveId) {
        leaveRecordService.deleteLeaveRecord(leaveId);
        return "Deleted Successfully";
    }
}