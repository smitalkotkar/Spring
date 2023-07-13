package com.bsms.service;

import java.util.List;  

import org.springframework.stereotype.Component;

import com.bsms.dto.CustomerDTO;
import com.bsms.entity.Customer;

@Component
public interface CustomerService {
	
    public CustomerDTO createCustomer(Customer customer); //method to create a User
	
	public CustomerDTO getCustomerById(int id); //method to retrieve a User
	
	public List<CustomerDTO>getAllCustomers(); //method to retrieve all Users
	
	public CustomerDTO updateCustomerById(int id, Customer customer); //method to update a User
	
	void deleteCustomerById(int id); //method to delete a User
	
	void deleteAllCustomers(); //method to delete all Users

	List<CustomerDTO> getCustomerUsingName(String name);//method used to fetch customer details using customer name
	
	CustomerDTO getCustomerByEmail(String email);//method used to fetch customer detail using email
	

}
