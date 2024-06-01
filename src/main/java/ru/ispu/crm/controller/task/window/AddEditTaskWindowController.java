package ru.ispu.crm.controller.task.window;

import org.springframework.web.bind.annotation.*;
import ru.ispu.crm.common.task.Task;
import ru.ispu.crm.controller.task.window.request_response.AddEditTaskRequest;
import ru.ispu.crm.controller.task.window.request_response.EmployeesResponse;
import ru.ispu.crm.helper.task.TaskHelper;

import java.util.UUID;

@RestController
@RequestMapping("/task_window")
@CrossOrigin
public class AddEditTaskWindowController {

    private final TaskHelper taskHelper;

    public AddEditTaskWindowController(TaskHelper taskHelper) {
        this.taskHelper= taskHelper;
    }

    @GetMapping("/employees")
    public EmployeesResponse getEmployees() {
        return taskHelper.getEmployees();
    }

    @PostMapping("/add_edit")
    public void addEditTask(@RequestBody AddEditTaskRequest request) {
        taskHelper.addEditTask(request);
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable("taskId") UUID taskId) {
        return taskHelper.getTask(taskId);
    }
}
