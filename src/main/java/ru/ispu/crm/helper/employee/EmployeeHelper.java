package ru.ispu.crm.helper.employee;

import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.common.employee.EmployeeFilter;
import ru.ispu.crm.common.employee.grid.EmployeesPageResponse;
import ru.ispu.crm.common.employee.window.AddEditEmployeeRequest;
import ru.ispu.crm.controller.employee.grid.EmployeeGridRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ispu.crm.service.employee.EmployeeService;

import java.util.List;

@Component
public class EmployeeHelper {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeHelper(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeesPageResponse getEmployees(EmployeeGridRequest request) {
        PageImpl<Employee> employeesPage = employeeService.getEmployees(toEmployeeFilter(request));
        return new EmployeesPageResponse(employeesPage.getElements(), employeesPage.getTotalPages());
    }

    private EmployeeFilter toEmployeeFilter(EmployeeGridRequest request) {
        return new EmployeeFilter(request.getCount(), request.getPage(), request.getActive());
    }
}
