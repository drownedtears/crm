package ru.ispu.crm.common.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskFilter {
    private Integer count;

    private Integer page;

    private TaskStatus status;
}
