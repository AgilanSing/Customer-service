package com.customerservice.dao;

import com.customerservice.entity.Customer;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : Customer Service
 * User: Agilan 
 * Email: agilan92@gmail.com
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
