package ru.ispu.crm.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.ispu.crm.common.employee.EmployeeFilter;
import org.springframework.stereotype.Service;
import ru.ispu.crm.dao.employee.EmployeeRepository;
import ru.ispu.crm.model.employee.EmployeeDb;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<EmployeeDb> getEmployees(EmployeeFilter employeeFilter) {
        return employeeRepository.findAll(PageRequest.of(employeeFilter.getPage(), employeeFilter.getCount()));
    }
}
