package ru.ispu.crm.controller.employee.grid.request_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeGridRequest {
    @JsonProperty("count")
    private Integer count;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("active")
    private Boolean active;
}
