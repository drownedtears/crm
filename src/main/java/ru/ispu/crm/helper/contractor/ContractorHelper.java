package ru.ispu.crm.helper.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ispu.crm.common.contractor.AddEditContractor;
import ru.ispu.crm.common.contractor.Contractor;
import ru.ispu.crm.common.contractor.ContractorFilter;
import ru.ispu.crm.controller.contractor.grid.request_response.ContractorGridRequest;
import ru.ispu.crm.controller.contractor.grid.request_response.ContractorsPageResponse;
import ru.ispu.crm.controller.contractor.window.request_response.AddEditContractorRequest;
import ru.ispu.crm.service.contractor.ContractorService;

import java.util.UUID;

@Component
public class ContractorHelper {
    private final ContractorService contractorService;

    @Autowired
    public ContractorHelper(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    public ContractorsPageResponse getContractors(ContractorGridRequest request) {
        var contractorsPage =  contractorService.getContractors(toContractorFilter(request));
        return new ContractorsPageResponse(contractorsPage.getElements(), contractorsPage.getTotalElements());
    }

    public void addEditContractor(AddEditContractorRequest request) {
        contractorService.addEditContractor(toAddEditContractor(request));
    }

    public Contractor getContractor(UUID contractorId) {
        return contractorService.getContractor(contractorId);
    }

    private AddEditContractor toAddEditContractor(AddEditContractorRequest request) {
        return new AddEditContractor(request);
    }

    private ContractorFilter toContractorFilter(ContractorGridRequest request) {
        return new ContractorFilter(request.getCount(), request.getPage(), request.getType());
    }
}
