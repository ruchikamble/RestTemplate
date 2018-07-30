package com.moneymoney.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymoney.customer.bean.Customer;
import com.moneymoney.customer.dao.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	/* (non-Javadoc)
	 * @see com.moneymoney.customer.service.CustomerService#addCustomer(com.moneymoney.customer.bean.Customer)
	 */
	@Override
	public void addCustomer(Customer customer) {
		repository.save(customer);
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.customer.service.CustomerService#viewAll()
	 */
	@Override
	public List<Customer> viewAll(){
		return repository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.moneymoney.customer.service.CustomerService#update(com.moneymoney.customer.bean.Customer)
	 */
	@Override
	public void update(Customer customer) {
		Optional<Customer> cust = repository.findById(customer.getCustomerId());
		Customer customer1 = cust.get();
		if(customer1 != null)
		{
			customer1.setFullName(customer.getFullName());
			customer1.setDateOfBirth(customer.getDateOfBirth().toString());
			customer1.setEmailId(customer.getEmailId());
			customer1.setPhoneNo(customer.getPhoneNo());
			repository.save(customer);
		}
		
	}
}
