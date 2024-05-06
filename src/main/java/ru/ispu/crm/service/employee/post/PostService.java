package ru.ispu.crm.service.employee.post;

import ru.ispu.crm.common.employee.post.AddEditEmployeePost;
import ru.ispu.crm.model.employee.PostDb;

import java.util.List;
import java.util.UUID;

public interface PostService {
    void addEditEmployeePost(AddEditEmployeePost addEditEmployeePost);

    List<PostDb> getEmployeePosts(UUID employeeId);
}
