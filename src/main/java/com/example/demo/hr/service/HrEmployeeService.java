package com.example.demo.hr.service;

import com.example.demo.hr.dao.HrEmployeeDao;
import com.example.demo.hr.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HrEmployeeService {

    private final HrEmployeeDao hrEmployeeDao;

    public HrEmployeeService(HrEmployeeDao hrEmployeeDao) {
        this.hrEmployeeDao = hrEmployeeDao;
    }

    @Transactional
    public void addEmployee(String name, Date dateOfJoining) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDateOfJoining(dateOfJoining);
        hrEmployeeDao.save(employee);
    }
}
