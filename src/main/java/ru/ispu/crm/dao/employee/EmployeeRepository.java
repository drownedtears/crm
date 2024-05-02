package ru.ispu.crm.dao.employee;

import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ispu.crm.model.employee.EmployeeDb;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDb, UUID> {
    Page<EmployeeDb> findAllByActive(Pageable pageable, Boolean active);
}
