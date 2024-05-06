package ru.ispu.crm.model.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.model.contractor.ContactDb;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee")
@Data
public class EmployeeDb {
    @Id
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "employee")
    private List<PostDb> postList = new ArrayList<>();
}
