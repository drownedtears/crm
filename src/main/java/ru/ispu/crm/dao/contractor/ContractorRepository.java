package ru.ispu.crm.dao.contractor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ispu.crm.model.contractor.ContractorDb;
import ru.ispu.crm.model.contractor.ContractorTypeDb;

import java.util.UUID;

public interface ContractorRepository extends JpaRepository<ContractorDb, UUID> {
    Page<ContractorDb> findAllByType(Pageable pageable, ContractorTypeDb type);
}
