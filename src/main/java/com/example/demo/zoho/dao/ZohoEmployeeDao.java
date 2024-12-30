package com.example.demo.zoho.dao;

import com.example.demo.zoho.dto.EmployeeLeaveSummary;
import com.example.demo.zoho.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZohoEmployeeDao {

    @PersistenceContext(unitName = "zoho")
    private EntityManager entityManager;

    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<EmployeeLeaveSummary> getAllEmployeesWithLeaveDays() {
        String jpql = "SELECT new com.example.demo.zoho.dto" +
                ".EmployeeLeaveSummary(e.employeeId, e.name, COALESCE(SUM(l.numberOfDays), 0)) " +
                "FROM Employee e LEFT JOIN e.leaves l " +
                "GROUP BY e.employeeId, e.name";
        TypedQuery<EmployeeLeaveSummary> query = entityManager.createQuery(jpql, EmployeeLeaveSummary.class);
        return query.getResultList();
    }

}
