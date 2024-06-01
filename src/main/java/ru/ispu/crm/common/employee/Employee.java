package ru.ispu.crm.common.employee;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.contact.Contact;
import ru.ispu.crm.common.employee.post.EmployeePost;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Employee {
    @NotNull
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

    @NotNull
    private List<EmployeePost> posts;
}
