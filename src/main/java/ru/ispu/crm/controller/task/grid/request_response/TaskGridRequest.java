package ru.ispu.crm.controller.task.grid.request_response;

import lombok.Data;
import ru.ispu.crm.common.task.TaskStatus;

@Data
public class TaskGridRequest {
    private Integer count;

    private Integer page;

    private TaskStatus status;
}
