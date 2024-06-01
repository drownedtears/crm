package ru.ispu.crm.helper.task;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ispu.crm.common.task.AddEditTask;
import ru.ispu.crm.common.task.Task;
import ru.ispu.crm.common.task.TaskFilter;
import ru.ispu.crm.common.task.TaskLink;
import ru.ispu.crm.controller.task.grid.request_response.TaskGridRequest;
import ru.ispu.crm.controller.task.grid.request_response.TaskGridResponse;
import ru.ispu.crm.controller.task.window.request_response.AddEditTaskRequest;
import ru.ispu.crm.controller.task.window.request_response.EmployeesResponse;
import ru.ispu.crm.service.employee.EmployeeService;
import ru.ispu.crm.service.task.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TaskHelper {
    private final TaskService taskService;

    private final EmployeeService employeeService;

    @Autowired
    public TaskHelper(TaskService taskService, EmployeeService employeeService) {
        this.taskService = taskService;
        this.employeeService = employeeService;
    }

    public TaskGridResponse getTasks(TaskGridRequest request) {
        var taskPage = taskService.getTasks(toTaskFilter(request));
        return new TaskGridResponse(taskPage.getElements(), taskPage.getTotalElements());
    }

    public EmployeesResponse getEmployees() {
        return new EmployeesResponse(employeeService.getEmployeesPageable());
    }

    public void addEditTask(AddEditTaskRequest request) {
        taskService.addEditTask(new AddEditTask(request));
    }

    public Task getTask(UUID taskId) {
        return taskService.getTask(taskId);
    }

    private TaskFilter toTaskFilter(TaskGridRequest request) {
        return new TaskFilter(request.getCount(), request.getPage(), request.getStatus());
    }
}
