package com.ideas2it.dao;

import com.ideas2it.model.Employee;
import com.ideas2it.model.LeaveRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRecordDao extends JpaRepository<LeaveRecords,Integer> {
    public List<LeaveRecords> findByEmployee(Employee employee);
}
