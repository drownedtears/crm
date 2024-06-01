package ru.ispu.crm.controller.task.grid;

import org.springframework.web.bind.annotation.*;
import ru.ispu.crm.controller.task.grid.request_response.TaskGridRequest;
import ru.ispu.crm.controller.task.grid.request_response.TaskGridResponse;
import ru.ispu.crm.helper.task.TaskHelper;

@RestController
@RequestMapping("/task_grid")
@CrossOrigin
public class TaskGridController {
    private final TaskHelper taskHelper;

    public TaskGridController(TaskHelper taskHelper) {
        this.taskHelper = taskHelper;
    }

    @PostMapping
    public TaskGridResponse getTasks(@RequestBody TaskGridRequest request) {
        return taskHelper.getTasks(request);
    }
}
