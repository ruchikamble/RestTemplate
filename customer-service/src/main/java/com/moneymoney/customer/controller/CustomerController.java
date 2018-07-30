package com.moneymoney.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moneymoney.customer.bean.Customer;
import com.moneymoney.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> addNewCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerService.viewAll();
		return customers;
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> update(@RequestBody Customer account) {
		customerService.update(account);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
