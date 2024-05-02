package ru.ispu.crm.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.Employee;
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
    public PageImpl<Employee> getEmployees(EmployeeFilter employeeFilter) {
        Page<EmployeeDb> employeesPage = employeeRepository.findAllByActive(
                PageRequest.of(employeeFilter.getPage(), employeeFilter.getCount()),
                employeeFilter.getActive());
        return new PageImpl<>(employeesPage.toList().stream().map(this::toEmployee).toList(), employeesPage.getTotalPages())
    }

    private Employee toEmployee(EmployeeDb employeeDb) {
        return new Employee(employeeDb.getId(), employeeDb.getName(), employeeDb.getSurname(), employeeDb.getPatronymic(), employeeDb.getActive());
    }
}
