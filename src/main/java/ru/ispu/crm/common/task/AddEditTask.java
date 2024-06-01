package ru.ispu.crm.common.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.controller.task.window.request_response.AddEditTaskRequest;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AddEditTask {
    private UUID id;

    private String title;

    private String description;

    private UUID executorId;

    private UUID inspectorId;

    private Long endDate;

    private TaskStatus status;

    private List<TaskLink> taskLinks;

    private String statusChangeComment;

    public AddEditTask(AddEditTaskRequest request) {
        this.id = request.getId();
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.executorId = request.getExecutorId();
        this.inspectorId = request.getInspectorId();
        this.endDate = request.getEndDate();
        this.status = request.getStatus();
        this.taskLinks = request.getTaskLinks();
        this.statusChangeComment = request.getStatusChangeComment();
    }
}
