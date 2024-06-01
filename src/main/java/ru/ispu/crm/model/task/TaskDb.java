package ru.ispu.crm.model.task;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import ru.ispu.crm.model.employee.EmployeeDb;
import ru.ispu.crm.model.employee.PostDb;
import ru.ispu.crm.model.task.task_link.TaskLinkDb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "task")
public class TaskDb {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private EmployeeDb executor;

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private EmployeeDb inspector;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatusDb status;

    @Column(name = "status_change_comment")
    private String statusChangeComment;

    @OneToMany(mappedBy = "task")
    private List<TaskLinkDb> taskLinkList = new ArrayList<>();

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeDb getExecutor() {
        return executor;
    }

    public void setExecutor(EmployeeDb executor) {
        this.executor = executor;
    }

    public EmployeeDb getInspector() {
        return inspector;
    }

    public void setInspector(EmployeeDb inspector) {
        this.inspector = inspector;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TaskStatusDb getStatus() {
        return status;
    }

    public void setStatus(TaskStatusDb status) {
        this.status = status;
    }

    public List<TaskLinkDb> getTaskLinkList() {
        return taskLinkList;
    }

    public void setTaskLinkList(List<TaskLinkDb> taskLinkList) {
        this.taskLinkList = taskLinkList;
    }

    public String getStatusChangeComment() {
        return statusChangeComment;
    }

    public void setStatusChangeComment(String statusChangeComment) {
        this.statusChangeComment = statusChangeComment;
    }
}
