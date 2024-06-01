package ru.ispu.crm.controller.employee.window.post_window.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.employee.post.EmployeePostResponseText;

@Data
@AllArgsConstructor
public class DeleteEmployeePostResponse {
    private EmployeePostResponseText responseText;
}
