package ru.ispu.crm.common.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContractorFilter {
    private Integer count;

    private Integer page;

    private String type;
}
