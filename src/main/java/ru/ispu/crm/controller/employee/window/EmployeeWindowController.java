package ru.ispu.crm.controller.employee.window;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ispu.crm.common.employee.window.AddEditEmployeeRequest;

@RestController
@RequestMapping("/employee_window")
public class EmployeeWindowController {
    public void addEditEmployee(@RequestBody AddEditEmployeeRequest request)
}
