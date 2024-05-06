package ru.ispu.crm.common.employee.post;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class EmployeePost {
    private UUID id;

    private UUID employeeId;

    private String name;

    private Boolean main;

    private PostSchedule schedule;
}
