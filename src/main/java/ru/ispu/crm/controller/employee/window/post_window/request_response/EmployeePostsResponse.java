package ru.ispu.crm.controller.employee.window.post_window.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.employee.post.EmployeePost;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeePostsResponse {
    List<EmployeePost> posts;
}
