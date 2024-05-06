package ru.ispu.crm.service.contractor;

import org.springframework.stereotype.Service;
import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.contractor.Contractor;
import ru.ispu.crm.common.contractor.ContractorFilter;

@Service
public class ContractorServiceImpl implements ContractorService {

    @Override
    public PageImpl<Contractor> getContractors(ContractorFilter contractorFilter) {
        return null;
    }
}
