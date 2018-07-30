package com.moneymoney.customer.service;

import java.util.List;

import com.moneymoney.customer.bean.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> viewAll();

	void update(Customer customer);

}