package ru.ispu.crm.controller.task.window.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.task.TaskLink;
import ru.ispu.crm.common.task.TaskStatus;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AddEditTaskRequest {
    private UUID id;

    private String title;

    private String description;

    private UUID executorId;

    private UUID inspectorId;

    private Long endDate;

    private TaskStatus status;

    private String statusChangeComment;

    private List<TaskLink> taskLinks;
}
