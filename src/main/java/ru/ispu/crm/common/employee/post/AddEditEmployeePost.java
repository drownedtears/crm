package ru.ispu.crm.common.employee.post;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.controller.employee.window.post_window.request_response.AddEditEmployeePostRequest;
import ru.ispu.crm.model.employee.PostSchedule;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AddEditEmployeePost {
    private UUID id;

    @NotNull
    private UUID employeeId;

    @NotNull
    private String name;

    @NotNull
    private Boolean main;

    @NotNull
    private PostSchedule schedule;

    public AddEditEmployeePost(AddEditEmployeePostRequest request) {
        this.id = request.getId();
        this.employeeId = request.getEmployeeId();
        this.name = request.getName();
        this.main = request.getMain();
        this.schedule = PostSchedule.valueOf(request.getSchedule());
    }
}
