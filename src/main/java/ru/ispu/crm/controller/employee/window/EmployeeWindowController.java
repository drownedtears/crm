package ru.ispu.crm.controller.employee.window;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.controller.employee.window.request_response.AddEditEmployeeRequest;
import ru.ispu.crm.helper.employee.EmployeeHelper;

import java.util.UUID;

@RestController
@RequestMapping("/employee_window")
public class EmployeeWindowController {

    private final EmployeeHelper employeeHelper;

    @Autowired
    public EmployeeWindowController(EmployeeHelper employeeHelper) {
        this.employeeHelper = employeeHelper;
    }

    @PostMapping("/add_edit")
    public void addEditEmployee(@Valid @RequestBody AddEditEmployeeRequest request) {
        employeeHelper.addEditEmployee(request);
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") UUID employeeId) {
        return employeeHelper.getEmployee(employeeId);
    }
}
