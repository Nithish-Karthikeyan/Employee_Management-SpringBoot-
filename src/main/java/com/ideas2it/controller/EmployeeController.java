package com.ideas2it.controller;

import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.dto.LeaveRecordsDTO;
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
    public String addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        int employeeId = employeeService.updateEmployee(employeeDTO);
        String status;
        if(employeeId == 0) status = "Employee Not Created";
        else status = "Employee Created Successfully with ID:"+employeeId;
        return status;
    }

    @GetMapping("/getEmployees")
    public List<EmployeeDTO> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployee/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int employeeId) throws EmployeeNotFoundException {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        int employeeId = employeeService.updateEmployee(employeeDTO);
        String status;
        if(employeeId == 0) status = "Employee Not Update";
        else status = "Employee Updated Successfully";
        return status;
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

    @PostMapping("/addLeaveRecord/{employeeId}")
    public String addLeaveRecord(@PathVariable int employeeId, @RequestBody LeaveRecordsDTO leaveRecordDTO) throws EmployeeNotFoundException {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        int leaveId = leaveRecordService.addLeaveRecord(leaveRecordDTO,employeeDTO);
        String status;
        if(leaveId == 0) status = "Leave Record Not Created";
        else status = "Leave Record Created Successfully";
        return status;
    }

    @GetMapping("/getLeaveRecordsByEmployeeId/{employeeId}")
    public List<LeaveRecordsDTO> getLeaveRecordsByEmployeeId(@PathVariable int employeeId) throws EmployeeNotFoundException {
        EmployeeDTO employee = employeeService.getEmployeeById(employeeId);
        return leaveRecordService.getLeaveRecords(employee);
    }

    @GetMapping("/getAllLeaveRecords")
    public List<LeaveRecordsDTO> getAllLeaveRecords() {
        return leaveRecordService.getAllLeaveRecords();
    }

    @DeleteMapping("/deleteLeaveRecord/{leaveId}")
    public String deleteLeaveRecord(@PathVariable int leaveId) {
        leaveRecordService.deleteLeaveRecord(leaveId);
        return "Deleted Successfully";
    }

    @PutMapping("/updateLeaveRecord")
    public String updateLeaveRecord(@Valid @RequestBody LeaveRecordsDTO leaveRecordDTO) {
        int leaveId = leaveRecordService.updateLeaveRecord(leaveRecordDTO);
        String status;
        if(leaveId == 0) status = "Leave Record Not Updated";
        else status = "Leave Record Updated Successfully";
        return status;
    }
}