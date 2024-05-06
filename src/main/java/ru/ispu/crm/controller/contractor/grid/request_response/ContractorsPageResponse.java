package ru.ispu.crm.controller.contractor.grid.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ispu.crm.common.contractor.Contractor;
import ru.ispu.crm.common.employee.Employee;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractorsPageResponse {
    private List<Contractor> contractors;

    private Integer totalPages;
}
