package ru.ispu.crm.common.contact;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Contact {
    private UUID id;

    private ContactType type;

    private String value;

    private Boolean main;
}
