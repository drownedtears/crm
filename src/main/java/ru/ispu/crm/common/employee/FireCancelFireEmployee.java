package ru.ispu.crm.common.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ispu.crm.controller.employee.grid.request_response.FireCancelFireEmployeeRequest;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FireCancelFireEmployee {
    private UUID employeeId;

    private Boolean fire;

    public FireCancelFireEmployee(FireCancelFireEmployeeRequest request) {
        this.employeeId = request.getEmployeeId();
        this.fire = request.getFire();
    }
}
