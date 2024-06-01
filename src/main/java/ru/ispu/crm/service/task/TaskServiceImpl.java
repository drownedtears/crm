package ru.ispu.crm.service.task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.common.employee.EmployeePageable;
import ru.ispu.crm.common.task.*;
import ru.ispu.crm.dao.employee.EmployeeRepository;
import ru.ispu.crm.dao.task.TaskLinkRepository;
import ru.ispu.crm.dao.task.TaskRepository;
import ru.ispu.crm.model.employee.EmployeeDb;
import ru.ispu.crm.model.employee.PostDb;
import ru.ispu.crm.model.task.TaskDb;
import ru.ispu.crm.model.task.TaskStatusDb;
import ru.ispu.crm.model.task.task_link.TaskLinkDb;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskLinkRepository taskLinkRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, EmployeeRepository employeeRepository, TaskLinkRepository taskLinkRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.taskLinkRepository = taskLinkRepository;
    }

    @Override
    public PageImpl<Task> getTasks(TaskFilter taskFilter) {
        var taskPage = taskRepository.findAllByStatus(PageRequest.of(taskFilter.getPage(), taskFilter.getCount()),
                TaskStatusDb.valueOf(taskFilter.getStatus().toString()));
        return new PageImpl<>(taskPage.stream().map(this::toTask).toList(), taskPage.getTotalPages() * taskFilter.getCount());
    }

    @Override
    @Transactional
    public void addEditTask(AddEditTask addEditTask) {
        //todo refactor
        var executor = employeeRepository.findById(addEditTask.getExecutorId()).orElseThrow();
        var inspector = employeeRepository.findById(addEditTask.getInspectorId()).orElseThrow();
        TaskDb taskDb;
        if (addEditTask.getId() != null) {
            taskDb = taskRepository.findById(addEditTask.getId()).orElseThrow();
        } else {
            taskDb = new TaskDb();
        }
        taskDb.setTitle(addEditTask.getTitle());
        taskDb.setDescription(addEditTask.getDescription());
        taskDb.setStatus(TaskStatusDb.valueOf(addEditTask.getStatus().toString()));
        taskDb.setEndDate(Date.from(Instant.ofEpochMilli(addEditTask.getEndDate())));
        taskDb.setExecutor(executor);
        taskDb.setStatusChangeComment(addEditTask.getStatusChangeComment());
        taskDb.setInspector(inspector);

        var savedTaskDb = taskRepository.save(taskDb);
        taskLinkRepository.deleteAllByTask_Id(savedTaskDb.getId());
        taskLinkRepository.saveAll(addEditTask.getTaskLinks().stream().map((taskLink) -> toTaskLinkDb(taskLink, savedTaskDb)).toList());
    }

    @Override
    public Task getTask(UUID taskId) {
        return toTask(taskRepository.findById(taskId).orElseThrow());
    }

    private Task toTask(TaskDb taskDb) {
        return new Task(taskDb.getId(), taskDb.getTitle(), taskDb.getDescription(), toEmployeePageable(taskDb.getExecutor()),
                toEmployeePageable(taskDb.getInspector()), taskDb.getEndDate().getTime(),
                TaskStatus.valueOf(taskDb.getStatus().toString()), taskDb.getStatusChangeComment(),
                taskDb.getTaskLinkList().stream().map(this::toTaskLink).toList());
    }

    private EmployeePageable toEmployeePageable(EmployeeDb employeeDb) {
        return new EmployeePageable(employeeDb.getId(), employeeDb.getName(), employeeDb.getSurname(),
                employeeDb.getPatronymic(), employeeDb.getPostList().stream().filter(PostDb::getMain).findFirst().orElseThrow().getName());
    }

    private TaskLink toTaskLink(TaskLinkDb taskLinkDb) {
        return new TaskLink(taskLinkDb.getId(), taskLinkDb.getShortName(), taskLinkDb.getDescription(), taskLinkDb.getUrl(), taskLinkDb.getTask().getId());
    }

    private TaskLinkDb toTaskLinkDb(TaskLink taskLink, TaskDb taskDb) {
        var taskLinkDb = new TaskLinkDb();
        taskLinkDb.setShortName(taskLink.getShortName());
        taskLinkDb.setDescription(taskLink.getDescription());
        taskLinkDb.setUrl(taskLink.getUrl());
        taskLinkDb.setTask(taskDb);
        return taskLinkDb;
    }
}
