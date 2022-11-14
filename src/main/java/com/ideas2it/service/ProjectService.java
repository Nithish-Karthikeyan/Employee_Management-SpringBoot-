package com.ideas2it.service;

import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    public int addProject(ProjectDTO projectDTO, EmployeeDTO employeeDTO, EmployeeDTO projectManagerDTO);

    public List<ProjectDTO> getAllProjects();

    public List<ProjectDTO> getProject(EmployeeDTO employee);

    public int updateProject(ProjectDTO projectDTO, EmployeeDTO employeeDTO, EmployeeDTO projectManagerDTO);
}
