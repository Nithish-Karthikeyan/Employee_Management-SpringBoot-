package com.ideas2it.model;

import javax.persistence.*;

@Entity
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
    private Employee employee;

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public void setEmployee(Employee employee) { this.employee = employee; }

    public Employee getEmployee() { return employee; }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
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
