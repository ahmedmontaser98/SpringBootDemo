package com.example.demo.zoho.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "leaverequest")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private int leaveId;

    @Column(name="leave_days")
    private int numberOfDays;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Leave() {
    }

    public Leave(int numberOfDays, Employee employee) {
        this.numberOfDays = numberOfDays;
        this.employee = employee;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
