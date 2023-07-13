package com.bsms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bsms.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	

	//custom method to get customer details using the customer name
	@Query("from Customer where custName=:name")
	List<Customer> getCustomerByName(@Param("name") String name);
	
	//custom method to get customer details using the customer email with finder method
	Customer findByEmail(String email);

}
