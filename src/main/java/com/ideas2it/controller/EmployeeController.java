package com.ideas2it.controller;

import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.dto.LeaveRecordsDTO;
import com.ideas2it.dto.ProjectDTO;
import com.ideas2it.exception.EmployeeNotFoundException;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.LeaveRecordService;
import com.ideas2it.service.ProjectService;
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

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String getIndex() {
        return "Welcome to Employee Management Application";
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        int employeeId = employeeService.addEmployee(employeeDTO);
        String status;
        if(employeeId == 0) status = "Employee Not Created";
        else status = "Employee Created Successfully with ID:"+employeeId;
        return ResponseEntity.ok(status);
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

    @PutMapping("/updateLeaveRecord/{employeeId}")
    public String updateLeaveRecord(@Valid @RequestBody LeaveRecordsDTO leaveRecordDTO, @PathVariable int employeeId) throws EmployeeNotFoundException {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        int leaveId = leaveRecordService.updateLeaveRecord(leaveRecordDTO, employeeDTO);
        String status;
        if(leaveId == 0) status = "Leave Record Not Updated";
        else status = "Leave Record Updated Successfully with ID:"+leaveId;
        return status;
    }

    @PostMapping("/addProject/{employeeId}/{projectManagerId}")
    public String addProject(@PathVariable int employeeId, @PathVariable int projectManagerId, @RequestBody ProjectDTO projectDTO) throws EmployeeNotFoundException {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        EmployeeDTO projectManagerDTO = employeeService.getEmployeeById(projectManagerId);
        int projectId = projectService.addProject(projectDTO,employeeDTO,projectManagerDTO);
        String status;
        if(projectId == 0) status = "Project Not Created";
        else status = "Project Created Successfully with ID:"+projectId;
        return status;
    }

    @GetMapping("/getAllProjects")
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/getProjectByEmployeeId/{employeeId}")
    public List<ProjectDTO> getProjectByEmployeeId(@PathVariable int employeeId) throws EmployeeNotFoundException {
        EmployeeDTO employee = employeeService.getEmployeeById(employeeId);
        return projectService.getProject(employee);
    }

    @PostMapping("/updateProject/{employeeId}/{projectManagerId}")
    public String updateProject(@PathVariable int employeeId, @PathVariable int projectManagerId, @RequestBody ProjectDTO projectDTO) throws EmployeeNotFoundException {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        EmployeeDTO projectManagerDTO = employeeService.getEmployeeById(projectManagerId);
        int projectId = projectService.updateProject(projectDTO,employeeDTO,projectManagerDTO);
        String status;
        if(projectId == 0) status = "Project Not Updated";
        else status = "Project Updated Successfully";
        return status;
    }
}