package ru.ispu.crm.model.employee.pageable;

import java.util.UUID;

public interface EmployeePageableDb {
    UUID getId();

    String getName();

    String getSurname();

    String getPatronymic();
}
