package ru.ispu.crm.helper.employee;

import ru.ispu.crm.common.employee.AddEditEmployee;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.common.employee.EmployeeFilter;
import ru.ispu.crm.common.employee.FireCancelFireEmployee;
import ru.ispu.crm.controller.employee.grid.request_response.EmployeesPageResponse;
import ru.ispu.crm.controller.employee.grid.request_response.EmployeeGridRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ispu.crm.controller.employee.grid.request_response.FireCancelFireEmployeeRequest;
import ru.ispu.crm.controller.employee.window.request_response.AddEditEmployeeRequest;
import ru.ispu.crm.service.employee.EmployeeService;

import java.util.UUID;

@Component
public class EmployeeHelper {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeHelper(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeesPageResponse getEmployees(EmployeeGridRequest request) {
        var employeesPage = employeeService.getEmployees(toEmployeeFilter(request));
        return new EmployeesPageResponse(employeesPage.getElements(), employeesPage.getTotalElements() * request.getCount());
    }

    public void addEditEmployee(AddEditEmployeeRequest request) {
        employeeService.addEditEmployee(toAddEditEmployee(request));
    }

    public void fireCancelFireEmployee(FireCancelFireEmployeeRequest request) {
        employeeService.fireCancelFireEmployee(new FireCancelFireEmployee(request));
    }

    public Employee getEmployee(UUID employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    private EmployeeFilter toEmployeeFilter(EmployeeGridRequest request) {
        return new EmployeeFilter(request.getCount(), request.getPage(), request.getActive());
    }

    private AddEditEmployee toAddEditEmployee(AddEditEmployeeRequest request) {
        return new AddEditEmployee(request);
    }
}
