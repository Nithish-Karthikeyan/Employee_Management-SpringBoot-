package com.ideas2it.service;

import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.dto.LeaveRecordsDTO;

import java.util.List;

public interface LeaveRecordService {
    public int addLeaveRecord(LeaveRecordsDTO leaveRecordDTO, EmployeeDTO employeeDTO);

    public List<LeaveRecordsDTO> getLeaveRecords(EmployeeDTO employeeDTO);

    public List<LeaveRecordsDTO> getAllLeaveRecords();

    public int updateLeaveRecord(LeaveRecordsDTO leaveRecordDTO, EmployeeDTO employeeDTO);

    public void deleteLeaveRecord(int leaveId);
}
