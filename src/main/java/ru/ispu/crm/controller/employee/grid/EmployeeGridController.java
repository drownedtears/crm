package ru.ispu.crm.controller.employee.grid;

import ru.ispu.crm.controller.employee.grid.request_response.EmployeeGridRequest;
import ru.ispu.crm.controller.employee.grid.request_response.EmployeesPageResponse;
import ru.ispu.crm.controller.employee.grid.request_response.FireCancelFireEmployeeRequest;
import ru.ispu.crm.helper.employee.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee_grid")
@CrossOrigin
public class EmployeeGridController {

    private final EmployeeHelper employeeHelper;

    @Autowired
    public EmployeeGridController(EmployeeHelper employeeHelper) {
        this.employeeHelper = employeeHelper;
    }

    @PostMapping
    public EmployeesPageResponse getEmployees(@RequestBody EmployeeGridRequest request) {
        return employeeHelper.getEmployees(request);
    }

    @PostMapping("/fire_cancel_fire")
    public void fireCancelFireEmployee(@RequestBody FireCancelFireEmployeeRequest fireCancelFireEmployeeRequest) {
        employeeHelper.fireCancelFireEmployee(fireCancelFireEmployeeRequest);
    }
}
