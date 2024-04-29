package ru.ispu.crm.dao.contractor;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ispu.crm.model.contractor.ContractorDb;

import java.util.UUID;

public interface ContractorRepository extends JpaRepository<ContractorDb, UUID> {

}
