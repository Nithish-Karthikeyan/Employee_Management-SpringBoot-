package com.ideas2it.dao;

import com.ideas2it.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    Employee findByName(String name);
}
