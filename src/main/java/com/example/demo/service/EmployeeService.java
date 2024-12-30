package com.example.demo.service;

import com.example.demo.hr.service.HrEmployeeService;
import com.example.demo.zoho.service.ZohoEmployeeService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeService {

    private final HrEmployeeService hrEmployeeService;
    private final ZohoEmployeeService zohoEmployeeService;

    public EmployeeService(HrEmployeeService hrEmployeeService, ZohoEmployeeService zohoEmployeeService) {
        this.hrEmployeeService = hrEmployeeService;
        this.zohoEmployeeService = zohoEmployeeService;
    }

    public void addEmployeeToBothDatabases(String name, Date dateOfJoining) {
        // Add employee to HR database
        hrEmployeeService.addEmployee(name, dateOfJoining);

        // Add employee to Zoho database
        zohoEmployeeService.addEmployee(name, dateOfJoining);
    }
}
