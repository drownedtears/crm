package ru.ispu.crm.helper.employee;

import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.AddEditEmployee;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.common.employee.EmployeeFilter;
import ru.ispu.crm.controller.employee.grid.EmployeesPageResponse;
import ru.ispu.crm.controller.employee.grid.EmployeeGridRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ispu.crm.controller.employee.window.AddEditEmployeeRequest;
import ru.ispu.crm.service.employee.EmployeeService;

import java.util.logging.Logger;

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

    public void addEditEmployee(AddEditEmployeeRequest request) {
        Logger.getAnonymousLogger().info(request.getPatronymic() + "aaaaaaaaaaaaaaaa");

    }

    private EmployeeFilter toEmployeeFilter(EmployeeGridRequest request) {
        return new EmployeeFilter(request.getCount(), request.getPage(), request.getActive());
    }

    private AddEditEmployee toAddEditEmployee(AddEditEmployeeRequest request) {
        return new
    }
}
