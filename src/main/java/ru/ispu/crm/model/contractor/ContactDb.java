package ru.ispu.crm.model.contractor;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "contact")
@Data
public class ContactDb {
    @Id
    private UUID id;

    @Column(name = "contact_type")
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private ContractorDb contractor;

    @Column(name = "main")
    private boolean main;
}
