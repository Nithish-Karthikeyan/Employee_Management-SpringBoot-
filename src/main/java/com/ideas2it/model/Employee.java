package com.ideas2it.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int employeeId;

    @NotBlank(message="Please Enter the Name")
    @Pattern(regexp = "([a-zA-Z]{1,10}[\\s.]?([a-zA-Z]{1,20}[\\s.]?)+)", message ="Name Should be in this Format e.g.(FirstName LastName)")
    private String name;

    @NotNull(message="Please Enter the Employee Type")
    private String employeeType;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String dateOfBirth;

    @NotNull(message = "Please enter the gender")
    private String gender;

    @Pattern(regexp = "^[6789]{1}[0-9]{9}", message = "Enter 10 digits mobile Number")
    private String mobileNumber;

    @Email(message = "Enter the valid email Id")
    @Pattern(regexp = "(^([a-z0-9_.-]{3,})+@([a-z0-9_.-]+)+[a-z.]{2,}$)", message = "Enter the valid E-mail Id e.g. abc@gmail.com")
    private String emailId;

    @NotBlank(message="Please Enter the Designation")
    @Pattern(regexp = "([a-zA-Z]{1,10}[\\s.]?([a-zA-Z]{1,20}[\\s.]?)+)", message ="Designation should contain only letters")
    private String designation;

    private String createdAt;
    private String modifiedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<LeaveRecords> leaveRecords;


    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;
}
