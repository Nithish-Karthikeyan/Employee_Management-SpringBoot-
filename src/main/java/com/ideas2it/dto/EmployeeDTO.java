package com.ideas2it.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

    private int employeeId;

    @NotBlank(message="Please Enter the Name")
    @Pattern(regexp = "([a-zA-Z]{1,10}[\\s.]?([a-zA-Z]{1,20}[\\s.]?)+)", message ="Name Should be in this Format e.g.(FirstName LastName)")
    private String name;

    @NotBlank(message="Please Enter the Employee Type")
    private String employeeType;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String dateOfBirth;

    @NotBlank(message = "Please enter the gender")
    private String gender;

    @Pattern(regexp = "^[6789]{1}[0-9]{9}", message = "Enter 10 digits mobile Number")
    private String mobileNumber;

    @Email(message = "Enter the valid email Id")
    @Pattern(regexp = "(^([a-z0-9_.-]{3,})+@([a-z0-9_.-]+)+[a-z.]{2,}$)", message = "Enter the valid E-mail Id e.g. abc@gmail.com")
    private String emailId;

    @NotBlank(message="Please Enter the Designation")
    @Pattern(regexp = "([a-zA-Z]{1,10}[\\s.]?([a-zA-Z]{1,20}[\\s.]?)+)", message ="Designation should contain only letters")
    private String designation;
}
