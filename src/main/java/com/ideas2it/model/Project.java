package com.ideas2it.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int projectId;

    private String projectName;
    private String startDate;
    private String projectManagerName;
    private String clientName;
    private String createdAt;
    private String modifiedAt;

    @ManyToMany
    @JoinTable(name = "employee_project", joinColumns = {@JoinColumn(name="employee_id")}, inverseJoinColumns = {@JoinColumn(name="project_id")})
    private List<Employee> employees;
}
