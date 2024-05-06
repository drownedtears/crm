package ru.ispu.crm.controller.contractor.window.request_response;

import lombok.Data;

import java.util.UUID;

@Data
public class AddEditContractorRequest {
    private UUID id;

    private String name;

    private String type;
}
