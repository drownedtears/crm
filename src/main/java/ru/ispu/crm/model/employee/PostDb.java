package ru.ispu.crm.model.employee;

import jakarta.persistence.*;
import lombok.Data;
import ru.ispu.crm.model.contractor.ContractorDb;

import java.util.UUID;

@Entity
@Table(name = "post")
@Data
public class PostDb {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeDb employee;

    @Column(name = "name")
    private String name;

    @Column(name = "main")
    private Boolean main;

    @Column(name = "schedule")
    @Enumerated(EnumType.STRING)
    private PostScheduleDb schedule;
}
