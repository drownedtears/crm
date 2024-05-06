package ru.ispu.crm.controller.employee.window.request_response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class AddEditEmployeeRequest {
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String patronymic;

    private Boolean active;
}
