package com.ideas2it.service;

import com.ideas2it.converter.EmployeeConverter;
import com.ideas2it.converter.ProjectConverter;
import com.ideas2it.dao.ProjectsDao;
import com.ideas2it.dateTimeUtils.DateTimeUtils;
import com.ideas2it.dto.EmployeeDTO;
import com.ideas2it.dto.ProjectDTO;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectsDao projectsDao;
    @Autowired
    private EmployeeConverter employeeConverter;
    @Autowired
    private ProjectConverter projectConverter;
    @Autowired
    private DateTimeUtils dateTimeUtils;

    @Override
    public int addProject(ProjectDTO projectDTO, EmployeeDTO employeeDTO, EmployeeDTO projectManagerDTO) {
        Employee employee = employeeConverter.employeeDTOtoEmployee(employeeDTO);
        Employee projectManager = employeeConverter.employeeDTOtoEmployee(projectManagerDTO);
        Project project = projectConverter.projectDTOToProject(projectDTO);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        project.setProjectManagerName(projectManager.getName());
        project.setEmployees(employees);
        project.setCreatedAt(dateTimeUtils.getDate());
        project.setModifiedAt(dateTimeUtils.getDate());
        return projectsDao.save(project).getProjectId();
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectsDao.findAll();
        return projectConverter.getProjects(projects);
    }

    @Override
    public List<ProjectDTO> getProject(EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.employeeDTOtoEmployee(employeeDTO);
        return projectConverter.getProjects(projectsDao.getProjectByEmployeeId(employee.getEmployeeId()));
    }

    @Override
    public int updateProject(ProjectDTO projectDTO, EmployeeDTO employeeDTO, EmployeeDTO projectManagerDTO) {
        Employee employee = employeeConverter.employeeDTOtoEmployee(employeeDTO);
        Employee projectManager = employeeConverter.employeeDTOtoEmployee(projectManagerDTO);
        Project project = projectConverter.projectDTOToProject(projectDTO);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        project.setProjectManagerName(projectManager.getName());
        project.setEmployees(employees);
        project.setModifiedAt(dateTimeUtils.getDate());
        Project existProject = projectsDao.findById(projectDTO.getProjectId()).get();
        project.setCreatedAt(existProject.getCreatedAt());
        return projectsDao.save(project).getProjectId();
    }
}
