package ru.ispu.crm.controller.employee.window.request_response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.ispu.crm.common.contact.Contact;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class AddEditEmployeeRequest {
    private UUID id;

    private String name;

    private String surname;

    private String patronymic;

    private Boolean active;

    private Long dateOfBirth;

    private String phone;

    private String email;

    private String additionalInfo;
}
