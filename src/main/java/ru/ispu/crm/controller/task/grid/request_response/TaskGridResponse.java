package ru.ispu.crm.controller.task.grid.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.task.Task;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskGridResponse {
    private List<Task> tasks;

    private Integer totalElements;
}
