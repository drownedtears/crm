package ru.ispu.crm.controller.employee.window;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.UUID;

@Data
public class AddEditEmployeeRequest {
    @Nullable
    private UUID id;

    private String name;

    private String surname;

    @Nullable
    private String patronymic;

    @Nullable
    private Boolean active;
}
