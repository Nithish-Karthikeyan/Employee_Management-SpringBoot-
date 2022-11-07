package com.ideas2it.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
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
    @OneToMany(mappedBy = "employee")
    private List<LeaveRecords> leaveRecords;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    public List<LeaveRecords> getLeaveRecords() {
        return leaveRecords;
    }

    public void setLeaveRecords(List<LeaveRecords> leaveRecords) {
        this.leaveRecords = leaveRecords;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}
