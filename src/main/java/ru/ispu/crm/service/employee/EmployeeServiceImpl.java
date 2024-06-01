package ru.ispu.crm.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.contact.Contact;
import ru.ispu.crm.common.contact.ContactType;
import ru.ispu.crm.common.employee.*;
import org.springframework.stereotype.Service;
import ru.ispu.crm.common.employee.post.EmployeePost;
import ru.ispu.crm.common.employee.post.PostSchedule;
import ru.ispu.crm.dao.employee.EmployeeRepository;
import ru.ispu.crm.dao.employee.post.PostRepository;
import ru.ispu.crm.model.common.ContactTypeDb;
import ru.ispu.crm.model.employee.EmployeeDb;
import ru.ispu.crm.model.employee.PostDb;
import ru.ispu.crm.model.employee.pageable.EmployeePageableDb;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final PostRepository postRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PostRepository postRepository) {
        this.employeeRepository = employeeRepository;
        this.postRepository = postRepository;
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
        employee.setAdditionalInfo(addEditEmployee.getAdditionalInfo());
        employee.setDateOfBirth(Date.from(Instant.ofEpochMilli(addEditEmployee.getDateOfBirth())));
        employee.setPhone(addEditEmployee.getPhone());
        employee.setEmail(addEditEmployee.getEmail());
        employee.setActive(true);
        employeeRepository.save(employee);
    }

    @Override
    public void fireCancelFireEmployee(FireCancelFireEmployee fireCancelFireEmployee) {
        var employeeDb = employeeRepository.findById(fireCancelFireEmployee.getEmployeeId()).orElseThrow();
        employeeDb.setActive(!fireCancelFireEmployee.getFire());
        Date lastWorkDate = fireCancelFireEmployee.getFire() ? new Date() : null;
        employeeDb.getPostList().forEach((post) -> post.setLastWorkDay(lastWorkDate));
        employeeRepository.save(employeeDb);
    }

    @Override
    public List<EmployeePageable> getEmployeesPageable() {
        return employeeRepository.findAll().stream().map(this::toEmployeePageable).toList();
    }

    @Override
    public Employee getEmployee(UUID employeeId) {
        return toEmployee(employeeRepository.findById(employeeId).orElseThrow());
    }

    private Employee toEmployee(EmployeeDb employeeDb) {
        return new Employee(employeeDb.getId(), employeeDb.getName(),
                employeeDb.getSurname(), employeeDb.getPatronymic(),
                employeeDb.getActive(), employeeDb.getDateOfBirth().getTime(), employeeDb.getPhone(), employeeDb.getEmail(),
                employeeDb.getAdditionalInfo(),
                employeeDb.getPostList().stream().map(this::toEmployeePost).toList());
    }

    private EmployeePost toEmployeePost(PostDb postDb) {
        return new EmployeePost(postDb.getId(), postDb.getEmployee().getId(), postDb.getName(),
                postDb.getMain(), PostSchedule.valueOf(postDb.getSchedule().toString()), postDb.getFirstWorkDay().getTime());
    }

    private EmployeePageable toEmployeePageable(EmployeeDb employeeDb) {
        var mainPostDb = employeeDb.getPostList().stream().filter(PostDb::getMain).findFirst().orElseThrow();
        return new EmployeePageable(employeeDb.getId(), employeeDb.getName(),
                employeeDb.getSurname(), employeeDb.getPatronymic(), mainPostDb.getName());
    }
}
