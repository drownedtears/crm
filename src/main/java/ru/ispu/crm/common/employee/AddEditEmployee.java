package ru.ispu.crm.common.employee;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.ispu.crm.controller.employee.window.request_response.AddEditEmployeeRequest;

import java.util.UUID;

@Data
public class AddEditEmployee {
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String patronymic;

    private Boolean active;

    public AddEditEmployee(AddEditEmployeeRequest request) {
        this.id = request.getId();
        this.name = request.getName();
        this.surname = request.getName();
        this.patronymic = request.getPatronymic();
        this.active = request.getActive();
    }
}
