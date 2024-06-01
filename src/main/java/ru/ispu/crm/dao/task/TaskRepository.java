package ru.ispu.crm.dao.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ispu.crm.model.task.TaskDb;
import ru.ispu.crm.model.task.TaskStatusDb;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskDb, UUID> {
    Page<TaskDb> findAllByStatus(Pageable pageable, TaskStatusDb status);

}
