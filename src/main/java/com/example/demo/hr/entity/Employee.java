package com.example.demo.hr.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_joining")
    private Date dateOfJoining;

    public Employee() {
    }

    public Employee(String name, Date dateOfJoining) {
        this.name = name;
        this.dateOfJoining = dateOfJoining;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
