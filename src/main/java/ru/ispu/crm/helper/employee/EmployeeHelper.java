package ru.ispu.crm.helper.employee;

import ru.ispu.crm.common.employee.EmployeeFilter;
import ru.ispu.crm.controller.employee.grid.EmployeeGridRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ispu.crm.service.employee.EmployeeService;

@Component
public class EmployeeHelper {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeHelper(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void getEmployees(EmployeeGridRequest request) {
        employeeService.getEmployees(toEmployeeFilter(request));
    }

    private EmployeeFilter toEmployeeFilter(EmployeeGridRequest request) {
        return new EmployeeFilter(request.getCount(), request.getPage());
    }
}
