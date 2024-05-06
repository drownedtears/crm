package ru.ispu.crm.controller.contractor.window;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ispu.crm.common.contractor.Contractor;
import ru.ispu.crm.controller.contractor.window.request_response.AddEditContractorRequest;
import ru.ispu.crm.helper.contractor.ContractorHelper;

import java.util.UUID;

@RestController
@RequestMapping("/contractor_window")
public class ContractorWindowController {

    private final ContractorHelper contractorHelper;

    @Autowired
    public ContractorWindowController(ContractorHelper contractorHelper) {
        this.contractorHelper = contractorHelper;
    }

    @PostMapping("/add_edit")
    public void addEditContractor(@Valid @RequestBody AddEditContractorRequest request) {
        contractorHelper.addEditContractor(request);
    }

    @GetMapping("/{contractorId}")
    public Contractor getContractor(@PathVariable("contractorId") UUID contractorId) {
        return contractorHelper.getContractor(contractorId);
    }
}
