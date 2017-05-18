package com.techm.customerservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.techm.customerservice.entity.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, Long>{
	public Customer findByUserName(String userName);
	//public String findByUserName(String userName);
}
