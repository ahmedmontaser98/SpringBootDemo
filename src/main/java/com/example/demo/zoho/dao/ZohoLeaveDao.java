package com.example.demo.zoho.dao;

import com.example.demo.zoho.entity.Leave;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZohoLeaveDao {

    @PersistenceContext(unitName = "zoho") // Ensure the persistence unit is configured correctly
    private EntityManager entityManager;

    public List<Leave> findAll() {
        String jpql = "SELECT l FROM Leave l"; // JPQL query to select all Leave records
        return entityManager.createQuery(jpql, Leave.class).getResultList();
    }
}
