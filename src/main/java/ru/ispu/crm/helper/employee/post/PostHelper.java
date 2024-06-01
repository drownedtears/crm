package ru.ispu.crm.helper.employee.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ispu.crm.common.employee.post.AddEditEmployeePost;
import ru.ispu.crm.common.employee.post.EmployeePost;
import ru.ispu.crm.common.employee.post.PostSchedule;
import ru.ispu.crm.controller.employee.window.post_window.request_response.AddEditEmployeePostRequest;
import ru.ispu.crm.controller.employee.window.post_window.request_response.AddEditEmployeePostResponse;
import ru.ispu.crm.controller.employee.window.post_window.request_response.DeleteEmployeePostResponse;
import ru.ispu.crm.controller.employee.window.post_window.request_response.EmployeePostsResponse;
import ru.ispu.crm.model.employee.PostDb;
import ru.ispu.crm.service.employee.post.PostService;

import java.util.UUID;

@Component
public class PostHelper {
    private final PostService postService;

    @Autowired
    public PostHelper(PostService postService) {
        this.postService = postService;
    }

    public AddEditEmployeePostResponse addEditEmployeePost(AddEditEmployeePostRequest request) {
        return new AddEditEmployeePostResponse(postService.addEditEmployeePost(toAddEditEmployeePost(request)));
    }

    public EmployeePostsResponse getEmployeePosts(UUID employeeId) {
        return new EmployeePostsResponse(postService.getEmployeePosts(employeeId));
    }

    public DeleteEmployeePostResponse deleteEmployeePost(UUID postId) {
        return new DeleteEmployeePostResponse(postService.deleteEmployeePost(postId));
    }

    private AddEditEmployeePost toAddEditEmployeePost(AddEditEmployeePostRequest request) {
        return new AddEditEmployeePost(request);
    }
}
