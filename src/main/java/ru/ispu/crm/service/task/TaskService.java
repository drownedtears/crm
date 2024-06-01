package ru.ispu.crm.service.task;

import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.common.employee.EmployeeFilter;
import ru.ispu.crm.common.task.AddEditTask;
import ru.ispu.crm.common.task.Task;
import ru.ispu.crm.common.task.TaskFilter;

import java.util.UUID;

public interface TaskService {
    PageImpl<Task> getTasks(TaskFilter taskFilter);

    void addEditTask(AddEditTask addEditTask);

    Task getTask(UUID taskId);
}
