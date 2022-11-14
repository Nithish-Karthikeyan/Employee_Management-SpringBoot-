package com.ideas2it.converter;

import com.ideas2it.dto.ProjectDTO;
import com.ideas2it.model.Project;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectConverter {

    public Project projectDTOToProject(ProjectDTO projectDTO){
        Project project = new Project();
        project.setProjectId(projectDTO.getProjectId());
        project.setProjectName(projectDTO.getProjectName());
        project.setClientName(projectDTO.getClientName());
        project.setStartDate(projectDTO.getStartDate());
        return project;
    }

    public ProjectDTO projectToProjectDTO(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(project.getProjectId());
        projectDTO.setProjectName(project.getProjectName());
        projectDTO.setProjectManagerName(project.getProjectManagerName());
        projectDTO.setClientName(project.getClientName());
        projectDTO.setStartDate(project.getStartDate());
        return projectDTO;
    }

    public List<ProjectDTO> getProjects(List<Project> projects) {
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for(Project project : projects) {
            projectDTOList.add(projectToProjectDTO(project));
        }
        return projectDTOList;
    }
}
