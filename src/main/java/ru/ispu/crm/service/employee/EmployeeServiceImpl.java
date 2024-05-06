package ru.ispu.crm.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.AddEditEmployee;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.common.employee.EmployeeFilter;
import org.springframework.stereotype.Service;
import ru.ispu.crm.dao.employee.EmployeeRepository;
import ru.ispu.crm.model.employee.EmployeeDb;

import java.util.logging.Logger;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public PageImpl<Employee> getEmployees(EmployeeFilter employeeFilter) {
        var employeesPage = employeeRepository.findAllByActive(
                PageRequest.of(employeeFilter.getPage(), employeeFilter.getCount()),
                employeeFilter.getActive());
        return new PageImpl<>(employeesPage.toList().stream().map(this::toEmployee).toList(), employeesPage.getTotalPages());
    }

    @Override
    public void addEditEmployee(AddEditEmployee addEditEmployee) {
        EmployeeDb employee;
        if (addEditEmployee.getId() != null) {
            employee = employeeRepository.findById(addEditEmployee.getId()).orElseThrow();
        } else {
            employee = new EmployeeDb();
        }
        employee.setName(addEditEmployee.getName());
        employee.setSurname(addEditEmployee.getSurname());
        employee.setPatronymic(addEditEmployee.getPatronymic());
        employee.setActive(addEditEmployee.getActive());
        employeeRepository.save(employee);
    }

    private Employee toEmployee(EmployeeDb employeeDb) {
        return new Employee(employeeDb.getId(), employeeDb.getName(), employeeDb.getSurname(), employeeDb.getPatronymic(), employeeDb.getActive());
    }
}
