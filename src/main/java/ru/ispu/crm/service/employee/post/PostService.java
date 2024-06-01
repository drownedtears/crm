package ru.ispu.crm.service.employee.post;

import ru.ispu.crm.common.employee.post.AddEditEmployeePost;
import ru.ispu.crm.common.employee.post.EmployeePostResponseText;
import ru.ispu.crm.common.employee.post.EmployeePost;

import java.util.List;
import java.util.UUID;

public interface PostService {
    EmployeePostResponseText addEditEmployeePost(AddEditEmployeePost addEditEmployeePost);

    List<EmployeePost> getEmployeePosts(UUID employeeId);

    EmployeePostResponseText deleteEmployeePost(UUID postId);
}
