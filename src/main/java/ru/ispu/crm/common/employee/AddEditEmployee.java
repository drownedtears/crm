package ru.ispu.crm.common.employee;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.ispu.crm.common.contact.Contact;
import ru.ispu.crm.controller.employee.window.request_response.AddEditEmployeeRequest;

import java.util.List;
import java.util.UUID;

@Data
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
