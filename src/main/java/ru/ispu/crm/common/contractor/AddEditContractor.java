package ru.ispu.crm.common.contractor;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.ispu.crm.controller.contractor.window.request_response.AddEditContractorRequest;

import java.util.UUID;

@Data
public class AddEditContractor {
    private UUID id;

    @NotNull
    private String name;

    private ContractorType type;

    public AddEditContractor(AddEditContractorRequest request) {
        this.id = request.getId();
        this.name = request.getName();
        this.type = ContractorType.valueOf(request.getType());
    }
}
