package ru.ispu.crm.common.employee;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.UUID;

@Data
public class Employee {
    private UUID id;

    private String name;

    private String surname;

    @Nullable
    private String patronymic;
}
