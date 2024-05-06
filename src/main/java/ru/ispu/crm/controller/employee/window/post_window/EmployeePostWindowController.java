package ru.ispu.crm.controller.employee.window.post_window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ispu.crm.controller.employee.window.post_window.request_response.AddEditEmployeePostRequest;
import ru.ispu.crm.controller.employee.window.post_window.request_response.EmployeePostsResponse;
import ru.ispu.crm.helper.employee.EmployeeHelper;
import ru.ispu.crm.helper.employee.post.PostHelper;

import java.util.UUID;

@RestController
@RequestMapping("/post")
public class EmployeePostWindowController {

    private final PostHelper postHelper;

    @Autowired
    public EmployeePostWindowController(PostHelper postHelper) {
        this.postHelper = postHelper;
    }

    @PostMapping("/add_edit")
    public void addEditEmployeePost(@RequestBody AddEditEmployeePostRequest request) {
        
    }

    @GetMapping("/employee/{employeeId}")
    public EmployeePostsResponse getEmployeePosts(@PathVariable UUID employeeId) {
        return postHelper.getEmployeePosts(employeeId);
    }
}
