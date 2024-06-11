package ru.ispu.crm.service.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.ispu.crm.common.PageImpl;
import ru.ispu.crm.common.employee.AddEditEmployee;
import ru.ispu.crm.common.employee.Employee;
import ru.ispu.crm.common.employee.EmployeeFilter;
import ru.ispu.crm.common.employee.FireCancelFireEmployee;
import ru.ispu.crm.dao.employee.EmployeeRepository;
import ru.ispu.crm.dao.employee.post.PostRepository;
import ru.ispu.crm.model.employee.EmployeeDb;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getEmployeesTest() {
        EmployeeFilter filter = new EmployeeFilter(0, 10, true);
        EmployeeDb employeeDb = new EmployeeDb();
        employeeDb.setId(UUID.randomUUID());
        employeeDb.setName("John");
        employeeDb.setSurname("Doe");
        employeeDb.setActive(true);
        employeeDb.setDateOfBirth(new Date());

        Page<EmployeeDb> employeeDbPage = new org.springframework.data.domain.PageImpl<>(Collections.singletonList(employeeDb));
        when(employeeRepository.findAllByActive(any(PageRequest.class), eq(true))).thenReturn(employeeDbPage);

        PageImpl<Employee> employees = employeeService.getEmployees(filter);

        assertEquals(1, employees.getElements().size());
        verify(employeeRepository, times(1)).findAllByActive(any(PageRequest.class), eq(true));
    }

    @Test
    public void addEditEmployeeTest() {
        AddEditEmployee addEditEmployee = new AddEditEmployee();
        addEditEmployee.setName("Jane");
        addEditEmployee.setSurname("Doe");
        addEditEmployee.setDateOfBirth(System.currentTimeMillis());

        employeeService.addEditEmployee(addEditEmployee);

        verify(employeeRepository, times(1)).save(any(EmployeeDb.class));
    }

    @Test
    public void fireCancelFireEmployeeTest() {
        UUID employeeId = UUID.randomUUID();
        EmployeeDb employeeDb = new EmployeeDb();
        employeeDb.setId(employeeId);
        employeeDb.setActive(true);
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employeeDb));

        FireCancelFireEmployee fireCancelFireEmployee = new FireCancelFireEmployee();
        fireCancelFireEmployee.setEmployeeId(employeeId);
        fireCancelFireEmployee.setFire(true);

        employeeService.fireCancelFireEmployee(fireCancelFireEmployee);

        assertFalse(employeeDb.getActive());
        verify(employeeRepository, times(1)).save(employeeDb);
    }

    @Test
    public void testGetEmployeesPageable() {
        EmployeeDb employeeDb = new EmployeeDb();
        employeeDb.setId(UUID.randomUUID());
        employeeDb.setName("John");
        employeeDb.setSurname("Doe");
        employeeDb.setPatronymic("Smith");
        employeeDb.setPostList(Collections.emptyList());

        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employeeDb));

        assertThrows(RuntimeException.class, () -> {
            employeeService.getEmployeesPageable();
        });

        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testGetEmployee() {
        UUID employeeId = UUID.randomUUID();
        EmployeeDb employeeDb = new EmployeeDb();
        employeeDb.setId(employeeId);
        employeeDb.setName("John");
        employeeDb.setSurname("Doe");
        employeeDb.setActive(true);
        employeeDb.setDateOfBirth(new Date());
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employeeDb));

        Employee employee = employeeService.getEmployee(employeeId);

        assertEquals("John", employee.getName());
        verify(employeeRepository, times(1)).findById(employeeId);
    }
}
