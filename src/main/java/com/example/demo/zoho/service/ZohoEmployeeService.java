package com.example.demo.zoho.service;

import com.example.demo.zoho.dao.ZohoEmployeeDao;
import com.example.demo.zoho.dto.EmployeeLeaveSummary;
import com.example.demo.zoho.entity.Employee;
import com.example.demo.zoho.entity.Leave;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ZohoEmployeeService {
    private final ZohoEmployeeDao zohoEmployeeDao;

    public ZohoEmployeeService(ZohoEmployeeDao zohoEmployeeDao) {
        this.zohoEmployeeDao = zohoEmployeeDao;
    }

    @Transactional(transactionManager = "zohoTransactionManager")
    public void addEmployee(String name, Date dateOfJoining) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDateOfJoining(dateOfJoining);
        zohoEmployeeDao.save(employee);
    }

    public List<EmployeeLeaveSummary> getAllEmployeesWithLeaveDays() {
        return zohoEmployeeDao.getAllEmployeesWithLeaveDays();
    }

}
