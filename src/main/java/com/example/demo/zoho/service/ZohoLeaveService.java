package com.example.demo.zoho.service;

import com.example.demo.zoho.dao.ZohoEmployeeDao;
import com.example.demo.zoho.entity.Employee;
import com.example.demo.zoho.entity.Leave;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ZohoLeaveService {


    private final ZohoEmployeeDao zohoEmployeeDao;

    public ZohoLeaveService(ZohoEmployeeDao zohoEmployeeDao) {
        this.zohoEmployeeDao = zohoEmployeeDao;
    }

    @Transactional(transactionManager = "zohoTransactionManager")
    public void requestLeave(int employeeId, int numberOfLeaveDays) {
        Employee employee = zohoEmployeeDao.findById(employeeId); // Find the employee

        if (employee == null) {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }

        Leave leave = new Leave();
        leave.setNumberOfDays(numberOfLeaveDays);
        leave.setEmployee(employee); // Set the employee for the leave

        // Add the leave to the employee's leave list
        employee.getLeaves().add(leave);

        // Save the employee to persist the leave
        zohoEmployeeDao.save(employee);
    }

}
