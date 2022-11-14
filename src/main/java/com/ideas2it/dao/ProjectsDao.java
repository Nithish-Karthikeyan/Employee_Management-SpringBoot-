package com.ideas2it.dao;

import com.ideas2it.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsDao extends JpaRepository<Project,Integer> {

    @Query(value = "SELECT p.project_id, p.client_name, p.project_manager_name, p.project_name, p.start_date FROM project AS p INNER JOIN employee_project AS e ON p.project_id = e.project_id WHERE e.employee_id = :employeeId",nativeQuery = true)
    public List<Project> getProjectByEmployeeId(int employeeId);
}
