package com.bsms.controller;

import java.util.List;    

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsms.dto.CustomerDTO;
import com.bsms.entity.Customer;
import com.bsms.service.CustomerService;
import com.bsms.util.CustomerConverter;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerConverter converter;
	
	//Create a customer
	@PostMapping("/customer")
	public CustomerDTO createCustomer(@RequestBody @Valid CustomerDTO customerDto)
	{
		final Customer customer = converter.convertToCustEntity(customerDto);
		return customerService.createCustomer(customer);
	}
	
	
	//build get customers details using id REST API
	@GetMapping("/customer/{custId}")
	public  CustomerDTO getCustomerById(@PathVariable("custId") int id)
	{
		return  customerService.getCustomerById(id);
	}

	
	//build get all customers details using REST API
	@GetMapping("/customers")
	public List<CustomerDTO> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	//Update customer details using id
	@PutMapping("/customer/{custId}")
	public CustomerDTO updateCustomerById(@PathVariable("custId") int custId, @Valid @RequestBody CustomerDTO customerDto)
	{
		final Customer customer = converter.convertToCustEntity(customerDto);
		return customerService.updateCustomerById(custId, customer);
	}
		
	
	 //Delete mapping to delete customer by id
	@DeleteMapping("/customer/{custId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("custId") int custId)
	{
		customerService.deleteCustomerById(custId);
	    return new ResponseEntity<String>("Customer details with id"+custId+" deleted succussfully.", HttpStatus.OK);
	}
		
	//Delete mapping to delete all the customers
	@DeleteMapping("/deleteAllEmp")
	public ResponseEntity<String> deleteAllCustomers()
	{
		customerService.deleteAllCustomers();
		return new ResponseEntity<String>("All customer details deleted successfully.",HttpStatus.OK);
	}
	
	//build get customers details using name
	@GetMapping("/getCustByName/{name}")
	public List<CustomerDTO> getCustomerByName(@PathVariable("name") String name)
	{
		return customerService.getCustomerUsingName(name);
		
	}
	
	//build get customers details using email
	@GetMapping("/getCustByEmail/{email}")
	public CustomerDTO getCustomerByEmail(@PathVariable("email") String email)
	{
		return customerService.getCustomerByEmail(email);
	}

}

