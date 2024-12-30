package com.example.demo.hr.dao;

import com.example.demo.hr.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class HrEmployeeDao {

    @PersistenceContext(unitName = "hr")
    private EntityManager entityManager;

    public void save(Employee employee) {
        entityManager.persist(employee);
    }
}
