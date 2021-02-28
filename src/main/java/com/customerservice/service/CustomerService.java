package com.customerservice.service;

import com.customerservice.dao.CustomerDao;
import com.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA. Project : Customer Service User: Agilan Email:
 * agilan92@gmail.com
 */
@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;

	public List<Customer> getAllCustomers() {
		return this.customerDao.findAll();
	}

	public Customer addCustomer(Customer customer) {
		return this.customerDao.save(customer);
	}

	public Optional<Customer> getCustomerById(int id) {
		return this.customerDao.findById(id);
	}

	public Customer updateCustomer(Customer customer) {
		return this.customerDao.save(customer);
	}

	public void deleteCustomerById(int id) {
		this.customerDao.deleteById(id);
	}

	public void deleteAllCustomers() {
		this.customerDao.deleteAll();
	}

}
