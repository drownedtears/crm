package ru.ispu.crm.common.contractor.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.model.contractor.contact.ContactTypeDb;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Contact {
    private UUID id;

    private ContactType type;

    private String value;

    private Boolean main;
}
