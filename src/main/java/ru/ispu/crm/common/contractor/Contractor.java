package ru.ispu.crm.common.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.contractor.contact.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Contractor {
    private UUID id;

    private String name;

    private ContractorType type;

    private List<Contact> contactList = new ArrayList<>();
}
