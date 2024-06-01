package ru.ispu.crm.dao.task;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ispu.crm.model.task.task_link.TaskLinkDb;

import java.util.UUID;

public interface TaskLinkRepository extends JpaRepository<TaskLinkDb, UUID> {
    void deleteAllByTask_Id(UUID taskId);
}
