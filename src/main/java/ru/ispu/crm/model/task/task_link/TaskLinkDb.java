package ru.ispu.crm.model.task.task_link;

import jakarta.persistence.*;
import ru.ispu.crm.model.employee.EmployeeDb;
import ru.ispu.crm.model.task.TaskDb;

import java.util.UUID;

@Entity
@Table(name = "task_link")
public class TaskLinkDb {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskDb task;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TaskDb getTask() {
        return task;
    }

    public void setTask(TaskDb task) {
        this.task = task;
    }
}
