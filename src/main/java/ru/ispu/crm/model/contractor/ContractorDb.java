package ru.ispu.crm.model.contractor;

import jakarta.persistence.*;
import lombok.Data;
import ru.ispu.crm.model.contractor.contact.ContractorContactDb;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contractor")
@Data
public class ContractorDb {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ContractorTypeDb type;

    @OneToMany(mappedBy = "contractor")
    private List<ContractorContactDb> contactList = new ArrayList<>();
}
