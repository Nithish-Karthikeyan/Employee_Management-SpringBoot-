package com.ideas2it.dao;

import com.ideas2it.model.LeaveRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRecordDao extends JpaRepository<LeaveRecords,Integer> {

    @Query(value = "SELECT * FROM leave_records WHERE employee_id = 'employeeId'", nativeQuery = true)
    public List<LeaveRecords> getLeaveRecords(int employeeId);
}
