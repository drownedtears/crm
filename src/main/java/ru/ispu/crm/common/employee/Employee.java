package ru.ispu.crm.common.employee;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Employee {
    private UUID id;

    private String name;

    private String surname;

    @Nullable
    private String patronymic;

    private Boolean active;
}
