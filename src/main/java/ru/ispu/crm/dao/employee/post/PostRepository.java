package ru.ispu.crm.dao.employee.post;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ispu.crm.model.employee.PostDb;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<PostDb, UUID> {
    List<PostDb> findAllByEmployee_Id(UUID employeeId);
}
