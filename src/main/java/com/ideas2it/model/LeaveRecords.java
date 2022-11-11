package com.ideas2it.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LeaveRecords {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int leaveId;
    private String fromDate;
    private String toDate;
    private String leaveType;
    private String createdAt;
    private String modifiedAt;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
}
