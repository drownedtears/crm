package ru.ispu.crm.service.employee;

import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.*;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    PageImpl<Employee> getEmployees(EmployeeFilter employeeFilter);

    void addEditEmployee(AddEditEmployee addEditEmployee);

    Employee getEmployee(UUID employeeId);

    void fireCancelFireEmployee(FireCancelFireEmployee fireCancelFireEmployee);

    List<EmployeePageable> getEmployeesPageable();
}
