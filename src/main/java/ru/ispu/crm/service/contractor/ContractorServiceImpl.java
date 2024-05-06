package ru.ispu.crm.service.contractor;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.contractor.AddEditContractor;
import ru.ispu.crm.common.contractor.Contractor;
import ru.ispu.crm.common.contractor.ContractorFilter;
import ru.ispu.crm.common.contractor.ContractorType;
import ru.ispu.crm.common.contractor.contact.Contact;
import ru.ispu.crm.common.contractor.contact.ContactType;
import ru.ispu.crm.dao.contractor.ContractorRepository;
import ru.ispu.crm.model.contractor.ContractorDb;
import ru.ispu.crm.model.contractor.ContractorTypeDb;
import ru.ispu.crm.model.contractor.contact.ContactDb;

import java.util.UUID;

@Service
public class ContractorServiceImpl implements ContractorService {

    private final ContractorRepository contractorRepository;

    public ContractorServiceImpl(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    @Override
    public PageImpl<Contractor> getContractors(ContractorFilter contractorFilter) {
        var contractorPage = contractorRepository.findAll(PageRequest.of(contractorFilter.getPage(), contractorFilter.getCount()));
        return new PageImpl<>(contractorPage.toList().stream().map(this::toContractor).toList(), contractorPage.getTotalPages());
    }

    @Override
    public void addEditContractor(AddEditContractor addEditContractor) {
        ContractorDb contractor;
        if (addEditContractor.getId() != null) {
            contractor = contractorRepository.findById(addEditContractor.getId()).orElseThrow();
        } else {
            contractor = new ContractorDb();
        }
        contractor.setName(addEditContractor.getName());
        contractor.setType(ContractorTypeDb.valueOf(addEditContractor.getType().toString()));
        contractorRepository.save(contractor);
    }

    @Override
    public Contractor getContractor(UUID contractorId) {
        return toContractor(contractorRepository.findById(contractorId).orElseThrow());
    }

    private Contractor toContractor(ContractorDb contractorDb) {
        return new Contractor(contractorDb.getId(),
                contractorDb.getName(),
                ContractorType.valueOf(contractorDb.getType().toString()),
                contractorDb.getContactList().stream().map(this::toContact).toList());
    }

    private Contact toContact(ContactDb contactDb) {
        return new Contact(contactDb.getId(),
                ContactType.valueOf(contactDb.getType().toString()),
                contactDb.getValue(),
                contactDb.isMain());
    }
}
