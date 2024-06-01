package ru.ispu.crm.controller.employee.window.post_window;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ispu.crm.controller.employee.window.post_window.request_response.AddEditEmployeePostRequest;
import ru.ispu.crm.controller.employee.window.post_window.request_response.AddEditEmployeePostResponse;
import ru.ispu.crm.controller.employee.window.post_window.request_response.DeleteEmployeePostResponse;
import ru.ispu.crm.controller.employee.window.post_window.request_response.EmployeePostsResponse;
import ru.ispu.crm.helper.employee.EmployeeHelper;
import ru.ispu.crm.helper.employee.post.PostHelper;

import java.util.UUID;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class EmployeePostWindowController {

    private final PostHelper postHelper;

    @Autowired
    public EmployeePostWindowController(PostHelper postHelper) {
        this.postHelper = postHelper;
    }

    @PostMapping("/add_edit")
    public AddEditEmployeePostResponse addEditEmployeePost(@Valid @RequestBody AddEditEmployeePostRequest request) {
        return postHelper.addEditEmployeePost(request);
    }

    @GetMapping("/{employeeId}")
    public EmployeePostsResponse getEmployeePosts(@PathVariable UUID employeeId) {
        return postHelper.getEmployeePosts(employeeId);
    }

    @DeleteMapping("/{postId}")
    public DeleteEmployeePostResponse deleteEmployeePost(@PathVariable UUID postId) {
        return postHelper.deleteEmployeePost(postId);
    }
}
