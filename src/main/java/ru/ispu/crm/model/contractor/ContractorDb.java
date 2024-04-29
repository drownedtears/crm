package ru.ispu.crm.model.contractor;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contractor")
@Data
public class ContractorDb {
    @Id
    private UUID id;

    @Column(name = "contractor_type")
    private ContractorType type;

    @OneToMany(mappedBy = "contractor")
    private List<ContactDb> contactList = new ArrayList<>();
}
