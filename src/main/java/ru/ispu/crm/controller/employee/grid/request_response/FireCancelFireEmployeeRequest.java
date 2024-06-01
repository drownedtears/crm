package ru.ispu.crm.controller.employee.grid.request_response;

import lombok.Data;

import java.util.UUID;

@Data
public class FireCancelFireEmployeeRequest {
    private UUID employeeId;

    private Boolean fire;
}
