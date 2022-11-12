package com.ideas2it.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LeaveRecordsDTO {

    private int leaveId;
    private String fromDate;
    private String toDate;
    private String leaveType;
}
