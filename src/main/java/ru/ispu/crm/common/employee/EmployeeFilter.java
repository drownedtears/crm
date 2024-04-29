package ru.ispu.crm.common.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeFilter {

    private Integer count;

    private Integer page;
}
