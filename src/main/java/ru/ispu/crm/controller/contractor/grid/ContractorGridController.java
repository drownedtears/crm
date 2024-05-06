package ru.ispu.crm.controller.contractor.grid;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ispu.crm.controller.contractor.grid.request_response.ContractorGridRequest;
import ru.ispu.crm.controller.contractor.grid.request_response.ContractorsPageResponse;
import ru.ispu.crm.controller.employee.grid.request_response.EmployeeGridRequest;
import ru.ispu.crm.controller.employee.grid.request_response.EmployeesPageResponse;
import ru.ispu.crm.helper.contractor.ContractorHelper;
import ru.ispu.crm.helper.employee.EmployeeHelper;

@RestController
@RequestMapping("/contractor_grid")
public class ContractorGridController {
    private final ContractorHelper contractorHelper;

    @Autowired
    public ContractorGridController(ContractorHelper contractorHelper) {
        this.contractorHelper = contractorHelper;
    }

    @PostMapping
    public ContractorsPageResponse getContractors(@Valid @RequestBody ContractorGridRequest request) {
        return contractorHelper.getContractors(request);
    }
}
