package com.ideas2it.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private String employeeType;
    private String dateOfBirth;
    private String gender;
    private String mobileNumber;
    private String emailId;
    private String designation;
    private String createdAt;
    private String modifiedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<LeaveRecords> leaveRecords;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;
}
