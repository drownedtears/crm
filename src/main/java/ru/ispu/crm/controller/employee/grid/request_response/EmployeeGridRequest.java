package ru.ispu.crm.controller.employee.grid.request_response;

import lombok.Data;

@Data
public class EmployeeGridRequest {
    private Integer count;

    private Integer page;

    private Boolean active;
}
