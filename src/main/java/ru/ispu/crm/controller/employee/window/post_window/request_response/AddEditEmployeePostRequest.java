package ru.ispu.crm.controller.employee.window.post_window.request_response;

import lombok.Data;

import java.util.UUID;

@Data
public class AddEditEmployeePostRequest {

    private UUID id;

    private UUID employeeId;

    private String name;

    private Boolean main;

    private String schedule;
}
