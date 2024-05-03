package ru.ispu.crm.common.employee;

import jakarta.annotation.Nullable;
import lombok.Data;
import ru.ispu.crm.controller.employee.window.AddEditEmployeeRequest;

import java.util.UUID;

@Data
public class AddEditEmployee {
    @Nullable
    private UUID id;

    private String name;

    private String surname;

    @Nullable
    private String patronymic;

    @Nullable
    private Boolean active;

    public AddEditEmployee(AddEditEmployeeRequest request) {
        this.
    }
}
