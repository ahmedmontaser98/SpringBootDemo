package com.example.demo.rest;

import com.example.demo.hr.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.zoho.dto.EmployeeLeaveSummary;
import com.example.demo.zoho.service.ZohoEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ZohoEmployeeService zohoEmployeeService;

    public EmployeeController(EmployeeService employeeService,
                              ZohoEmployeeService zohoEmployeeService) {
        this.employeeService = employeeService;
        this.zohoEmployeeService = zohoEmployeeService;
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee TheEmployee) {
        TheEmployee.setEmployeeId(0);

        // Parse the dateOfJoining parameter
        Date joiningDate = TheEmployee.getDateOfJoining();

        String name = TheEmployee.getName();

        // Add employee to both databases
        employeeService.addEmployeeToBothDatabases(name, joiningDate);
        return "Employee added to both databases successfully!";
    }

    @PostMapping("/zoho")
    public void addZohoEmployee(@RequestBody Employee TheEmployee) {
        TheEmployee.setEmployeeId(0);

        // Parse the dateOfJoining parameter
        Date joiningDate = TheEmployee.getDateOfJoining();

        String name = TheEmployee.getName();

        // Add employee to Zoho database
        zohoEmployeeService.addEmployee(name, joiningDate);
    }

    @GetMapping("/leaves")
    public List<EmployeeLeaveSummary> getAllEmployeesWithLeaveDays() {
        return zohoEmployeeService.getAllEmployeesWithLeaveDays();
    }

}
