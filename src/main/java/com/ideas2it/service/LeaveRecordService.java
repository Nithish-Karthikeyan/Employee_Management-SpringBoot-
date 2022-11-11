package com.ideas2it.service;

import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.model.Employee;
import com.ideas2it.model.LeaveRecords;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaveRecordService {
    public LeaveRecords addLeaveRecord(LeaveRecords leaveRecord);

    public List<LeaveRecords> getLeaveRecords(Employee employee);

    public List<LeaveRecords> getAllLeaveRecords();

    void deleteLeaveRecord(int leaveId);
}
