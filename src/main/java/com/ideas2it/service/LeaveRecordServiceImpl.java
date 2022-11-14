package com.ideas2it.service;

import com.ideas2it.converter.EmployeeConverter;
import com.ideas2it.converter.LeaveRecordsConverter;
import com.ideas2it.dao.LeaveRecordDao;
import com.ideas2it.dateTimeUtils.DateTimeUtils;
import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.dto.LeaveRecordsDTO;
import com.ideas2it.model.Employee;
import com.ideas2it.model.LeaveRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRecordServiceImpl implements LeaveRecordService {

    @Autowired
    private LeaveRecordDao leaveRecordDao;

    @Autowired
    private DateTimeUtils dateTimeUtils;

    @Autowired
    private LeaveRecordsConverter leaveRecordsConverter;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    public int addLeaveRecord(LeaveRecordsDTO leaveRecordDTO, EmployeeDTO employeeDTO) {
        LeaveRecords leaveRecord = leaveRecordsConverter.leaveRecordDTOtoLeaveRecord(leaveRecordDTO);
        Employee employee = employeeConverter.employeeDTOtoEmployee(employeeDTO);
        leaveRecord.setEmployee(employee);
        leaveRecord.setCreatedAt(dateTimeUtils.getDate());
        leaveRecord.setModifiedAt(dateTimeUtils.getDate());
        return leaveRecordDao.save(leaveRecord).getLeaveId();
    }

    public List<LeaveRecordsDTO> getLeaveRecords(EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.employeeDTOtoEmployee(employeeDTO);
        return leaveRecordsConverter.getLeaves(leaveRecordDao.findByEmployee(employee));
    }

    @Override
    public List<LeaveRecordsDTO> getAllLeaveRecords() {
        List<LeaveRecords> leaveRecords = leaveRecordDao.findAll();
        return leaveRecordsConverter.getLeaves(leaveRecords);
    }

    @Override
    public int updateLeaveRecord(LeaveRecordsDTO leaveRecordDTO, EmployeeDTO employeeDTO) {
        LeaveRecords leaveRecord = leaveRecordsConverter.leaveRecordDTOtoLeaveRecord(leaveRecordDTO);
        Employee employee = employeeConverter.employeeDTOtoEmployee(employeeDTO);
        leaveRecord.setEmployee(employee);
        leaveRecord.setModifiedAt(dateTimeUtils.getDate());
        LeaveRecords existLeaveRecord = leaveRecordDao.findById(leaveRecordDTO.getLeaveId()).get();
        leaveRecord.setCreatedAt(existLeaveRecord.getCreatedAt());
        return leaveRecordDao.save(leaveRecord).getLeaveId();
    }

    @Override
    public void deleteLeaveRecord(int leaveId) {
        leaveRecordDao.deleteById(leaveId);
    }
}
