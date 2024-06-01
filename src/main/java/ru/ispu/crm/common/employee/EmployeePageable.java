package ru.ispu.crm.common.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class EmployeePageable {
    private UUID id;

    private String name;

    private String surname;

    private String patronymic;

    private String mainPostName;
}
