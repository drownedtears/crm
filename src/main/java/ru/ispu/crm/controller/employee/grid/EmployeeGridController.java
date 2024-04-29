package ru.ispu.crm.controller.employee.grid;

import ru.ispu.crm.helper.employee.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee_grid")
public class EmployeeGridController {

    private final EmployeeHelper employeeHelper;

    @Autowired
    public EmployeeGridController(EmployeeHelper employeeHelper) {
        this.employeeHelper = employeeHelper;
    }

    @PostMapping
    public void getEmployees(@RequestBody EmployeeGridRequest request) {
        employeeHelper.getEmployees(request);
    }
}
