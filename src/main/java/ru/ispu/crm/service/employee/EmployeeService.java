package ru.ispu.crm.service.employee;

import org.springframework.data.domain.Page;
import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.AddEditEmployee;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.common.employee.EmployeeFilter;
import ru.ispu.crm.model.employee.EmployeeDb;

import java.util.List;

public interface EmployeeService {
    PageImpl<Employee> getEmployees(EmployeeFilter employeeFilter);

    void addEditEmployee(AddEditEmployee addEditEmployee);
}
