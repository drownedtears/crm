package ru.ispu.crm.controller.employee.window;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee_window")
public class EmployeeWindowController {
    @PostMapping("/add_edit")
    public void addEditEmployee(@RequestBody AddEditEmployeeRequest request) {

    }
}
