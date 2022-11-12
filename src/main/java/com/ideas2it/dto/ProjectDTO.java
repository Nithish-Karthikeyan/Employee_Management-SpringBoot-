package com.ideas2it.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO {

    private int projectId;
    private String projectName;
    private String startDate;
    private String projectManagerName;
    private String clientName;
}
