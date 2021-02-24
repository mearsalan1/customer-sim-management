package com.csms.repository;

import com.csms.model.Customer;
import com.csms.model.Sim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimRepository extends JpaRepository<Sim, Integer> {
    List<Sim> findByCustomerId(Integer customerId);
}