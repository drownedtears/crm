package ru.ispu.crm.controller.employee.window;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ispu.crm.controller.employee.window.request_response.AddEditEmployeeRequest;
import ru.ispu.crm.helper.employee.EmployeeHelper;

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
}
