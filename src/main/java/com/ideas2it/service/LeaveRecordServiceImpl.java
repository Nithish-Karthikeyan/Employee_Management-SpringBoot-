package com.ideas2it.service;

import com.ideas2it.dao.LeaveRecordDao;
import com.ideas2it.dateTimeUtils.DateTimeUtils;
import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.model.Employee;
import com.ideas2it.model.LeaveRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRecordServiceImpl implements LeaveRecordService {

    @Autowired
    private LeaveRecordDao leaveRecordDao;

    DateTimeUtils dateTimeUtils = new DateTimeUtils();

    @Override
    public LeaveRecords addLeaveRecord(LeaveRecords leaveRecord) {
        leaveRecord.setCreatedAt(dateTimeUtils.getDate());
        leaveRecord.setModifiedAt(dateTimeUtils.getDate());
        return leaveRecordDao.save(leaveRecord);
    }

    public List<LeaveRecords> getLeaveRecords(Employee employee) {
        return leaveRecordDao.findByEmployee(employee);
    }

    @Override
    public List<LeaveRecords> getAllLeaveRecords() {
        return leaveRecordDao.findAll();
    }

    @Override
    public void deleteLeaveRecord(int leaveId) {
        leaveRecordDao.deleteById(leaveId);
    }
}
