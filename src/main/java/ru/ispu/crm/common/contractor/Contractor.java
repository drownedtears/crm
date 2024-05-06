package ru.ispu.crm.common.contractor;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Contractor {
    @NotNull
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private ContractorType type;
}
