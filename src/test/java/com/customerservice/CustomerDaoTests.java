package com.customerservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.customerservice.dao.CustomerDao;
import com.customerservice.entity.Customer;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class CustomerDaoTests {

	
	@Autowired
	private CustomerDao dao;
	private static int custId;

	private Customer cust = new Customer("Agilan", "Agilan", "M", 29, "9876543210");

	@Test
	@Rollback(false)
	@Order(1)
	public void testSaveNewCustomer() {
		cust = dao.save(cust);
		custId = cust.getId();
		assertThat(cust.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void testListCustomers() {
		List<Customer> customer = (List<Customer>) dao.findAll();
		assertThat(customer).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void getCustomerById() {
		Optional<Customer> customer = dao.findById(custId);
		assertThat(customer).isNotNull();
	}

	@Test
	@Order(4)
	public void updateCustomer() {
		cust.setLastName("AgilanS");
		Customer saveCustomer = dao.save(cust);
		assertThat(saveCustomer).isSameAs(cust);
	}

	@Test
	@Order(5)
	public void deleteCustomer() {
		dao.deleteById(custId);
		assertThat(dao.findById(custId));
	}

}
