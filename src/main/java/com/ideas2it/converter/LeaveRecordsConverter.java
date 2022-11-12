package com.ideas2it.converter;

import com.ideas2it.dateTimeUtils.DateTimeUtils;
import com.ideas2it.dto.LeaveRecordsDTO;
import com.ideas2it.model.LeaveRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LeaveRecordsConverter {
    @Autowired
    private DateTimeUtils dateTimeUtils;
    public LeaveRecords leaveRecordDTOtoLeaveRecord(LeaveRecordsDTO leaveRecordsDTO){
        LeaveRecords leaveRecord = new LeaveRecords();
        leaveRecord.setLeaveId(leaveRecordsDTO.getLeaveId());
        leaveRecord.setLeaveType(leaveRecordsDTO.getLeaveType());
        leaveRecord.setFromDate(leaveRecordsDTO.getFromDate());
        leaveRecord.setToDate(leaveRecordsDTO.getToDate());
        leaveRecord.setCreatedAt(dateTimeUtils.getDate());
        leaveRecord.setModifiedAt(dateTimeUtils.getDate());
        return leaveRecord;
    }

    public LeaveRecordsDTO leaveRecordToLeaveRecordDTO(LeaveRecords leaveRecord) {
        LeaveRecordsDTO leaveRecordsDTO = new LeaveRecordsDTO();
        leaveRecordsDTO.setLeaveId(leaveRecord.getLeaveId());
        leaveRecordsDTO.setLeaveType(leaveRecord.getLeaveType());
        leaveRecordsDTO.setFromDate(leaveRecord.getFromDate());
        leaveRecordsDTO.setToDate(leaveRecord.getToDate());
        return leaveRecordsDTO;
    }

    public List<LeaveRecordsDTO> getLeaves(List<LeaveRecords> leaveRecords) {
        List<LeaveRecordsDTO> leaveRecordsDTOList = new ArrayList<>();
        for(LeaveRecords leaveRecord : leaveRecords) {
            leaveRecordsDTOList.add(leaveRecordToLeaveRecordDTO(leaveRecord));
        }
        return leaveRecordsDTOList;
    }
}