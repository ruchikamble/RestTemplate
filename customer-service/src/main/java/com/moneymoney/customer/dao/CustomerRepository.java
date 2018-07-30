package com.moneymoney.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moneymoney.customer.bean.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
