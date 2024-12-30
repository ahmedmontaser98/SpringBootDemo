package com.example.demo.zoho.dto;

public class EmployeeLeaveSummary {

    private long employeeId;
    private String employeeName;
    private long totalLeaveDays;

    public EmployeeLeaveSummary(long employeeId, String employeeName,
                                long totalLeaveDays) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.totalLeaveDays = totalLeaveDays;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getTotalLeaveDays() {
        return totalLeaveDays;
    }

    public void setTotalLeaveDays(long totalLeaveDays) {
        this.totalLeaveDays = totalLeaveDays;
    }
}
