package ru.ispu.crm.controller.task.window.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.employee.EmployeePageable;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeesResponse {
    private List<EmployeePageable> employees;
}
