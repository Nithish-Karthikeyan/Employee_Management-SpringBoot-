package com.ideas2it.service;

import com.ideas2it.model.LeaveRecords;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaveRecordService {
    public LeaveRecords addLeaveRecord(LeaveRecords leaveRecord);

    public List<LeaveRecords> getLeaveRecords(int employeeId);

    public List<LeaveRecords> getAllLeaveRecords();

    void deleteLeaveRecord(int leaveId);
}
