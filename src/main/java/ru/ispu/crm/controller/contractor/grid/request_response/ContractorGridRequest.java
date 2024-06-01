package ru.ispu.crm.controller.contractor.grid.request_response;

import lombok.Data;

@Data
public class ContractorGridRequest {
    private Integer count;

    private Integer page;

    private String type;
}
