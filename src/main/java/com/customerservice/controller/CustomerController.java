package com.customerservice.controller;

import com.customerservice.entity.Customer;
import com.customerservice.exception.ResourceNotFoundException;
import com.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA. Project : Customer Service User: Agilan Email:
 * agilan92@gmail.com
 */
@RestController
@RequestMapping("/cust")
@Validated
public class CustomerController {
	@Autowired
	CustomerService custService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return this.custService.getAllCustomers();
	}

	@RequestMapping(value = "/addcust", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return this.custService.addCustomer(customer);
	}

	@RequestMapping(value = "/updatecust", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		// Before updating the record , check the Data available in Database
		this.custService.getCustomerById(customer.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customer.getId()));
		return this.custService.updateCustomer(customer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getCustmomer(@PathVariable int id) {
		return this.custService.getCustomerById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.DELETE)
	public void deleteAllCustomers() {
		this.custService.deleteAllCustomers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable int id) {
		// Before deleting the record , check the Data available in Database
		this.custService.getCustomerById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
		this.custService.deleteCustomerById(id);
	}

}
