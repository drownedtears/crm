package ru.ispu.crm.service.contractor;

import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.contractor.Contractor;
import ru.ispu.crm.common.contractor.ContractorFilter;
import ru.ispu.crm.model.contractor.ContractorDb;

public interface ContractorService {
    PageImpl<Contractor> getContractors(ContractorFilter contractorFilter);
}
