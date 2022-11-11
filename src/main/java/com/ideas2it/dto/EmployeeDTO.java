package com.ideas2it.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

    private int employeeId;
    private String name;
    private String employeeType;
    private String dateOfBirth;
    private String gender;
    private String mobileNumber;
    private String emailId;
    private String designation;
}
