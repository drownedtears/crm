package ru.ispu.crm.common.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.employee.EmployeePageable;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Task {
    private UUID id;

    private String title;

    private String description;

    private EmployeePageable executor;

    private EmployeePageable inspector;

    private Long endDate;

    private TaskStatus status;

    private String statusChangeComment;

    private List<TaskLink> taskLinks;
}
