package ru.ispu.crm.service.employee;

import org.springframework.data.domain.Page;
import ru.ispu.crm.common.employee.EmployeeFilter;
import ru.ispu.crm.model.employee.EmployeeDb;

import java.util.List;

public interface EmployeeService {
    Page<EmployeeDb> getEmployees(EmployeeFilter employeeFilter);
}
