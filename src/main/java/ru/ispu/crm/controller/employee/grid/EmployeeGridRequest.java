package ru.ispu.crm.controller.employee.grid;

import lombok.Data;

@Data
public class EmployeeGridRequest {
    private Integer count;

    private Integer page;

    private Boolean active;
}
