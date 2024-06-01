package ru.ispu.crm.model.employee;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import ru.ispu.crm.model.contractor.ContractorDb;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "post")
public class PostDb {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeDb employee;

    @Column(name = "name")
    private String name;

    @Column(name = "main")
    private Boolean main;

    @Column(name = "schedule")
    @Enumerated(EnumType.STRING)
    private PostScheduleDb schedule;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "first_work_day")
    private Date firstWorkDay;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_work_day")
    private Date lastWorkDay;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EmployeeDb getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDb employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public PostScheduleDb getSchedule() {
        return schedule;
    }

    public void setSchedule(PostScheduleDb schedule) {
        this.schedule = schedule;
    }

    public Date getFirstWorkDay() {
        return firstWorkDay;
    }

    public void setFirstWorkDay(Date firstWorkDay) {
        this.firstWorkDay = firstWorkDay;
    }

    public Date getLastWorkDay() {
        return lastWorkDay;
    }

    public void setLastWorkDay(Date lastWorkDay) {
        this.lastWorkDay = lastWorkDay;
    }
}
