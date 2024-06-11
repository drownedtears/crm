package ru.ispu.crm.common.employee;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ispu.crm.controller.employee.window.request_response.AddEditEmployeeRequest;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AddEditEmployee {
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String patronymic;

    @NotNull
    private Boolean active;

    @NotNull
    private Long dateOfBirth;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    private String additionalInfo;

    public AddEditEmployee(AddEditEmployeeRequest request) {
        this.id = request.getId();
        this.name = request.getName();
        this.surname = request.getSurname();
        this.patronymic = request.getPatronymic();
        this.active = request.getActive();
        this.dateOfBirth = request.getDateOfBirth();
        this.phone = request.getPhone();
        this.email = request.getEmail();
        this.additionalInfo = request.getAdditionalInfo();
    }
}
