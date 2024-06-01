package ru.ispu.crm.controller.employee.window.post_window.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.employee.post.EmployeePostResponseText;

@AllArgsConstructor
@Data
public class AddEditEmployeePostResponse {
    private EmployeePostResponseText responseText;
}
