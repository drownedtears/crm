package ru.ispu.crm.common.employee.grid;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.employee.Employee;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeesPageResponse {
    private List<Employee> employees;

    private Integer totalPages;
}
