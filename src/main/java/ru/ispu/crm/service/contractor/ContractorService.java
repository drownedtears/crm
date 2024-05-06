package ru.ispu.crm.service.contractor;

import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.contractor.AddEditContractor;
import ru.ispu.crm.common.contractor.Contractor;
import ru.ispu.crm.common.contractor.ContractorFilter;
import ru.ispu.crm.model.contractor.ContractorDb;

import java.util.UUID;

public interface ContractorService {
    PageImpl<Contractor> getContractors(ContractorFilter contractorFilter);

    void addEditContractor(AddEditContractor addEditContractor);

    Contractor getContractor(UUID contractorId);
}
