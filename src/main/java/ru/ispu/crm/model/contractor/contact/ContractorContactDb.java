package ru.ispu.crm.model.contractor.contact;

import jakarta.persistence.*;
import lombok.Data;
import ru.ispu.crm.model.common.ContactTypeDb;
import ru.ispu.crm.model.contractor.ContractorDb;

import java.util.UUID;

@Entity
@Table(name = "contractor_contact")
@Data
public class ContractorContactDb {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ContactTypeDb type;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private ContractorDb contractor;

    @Column(name = "main")
    private boolean main;
}
