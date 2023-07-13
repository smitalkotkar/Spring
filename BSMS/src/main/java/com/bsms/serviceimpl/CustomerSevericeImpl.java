package com.bsms.serviceimpl;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsms.dto.CustomerDTO;
import com.bsms.entity.Customer;
import com.bsms.exception.PropertyAlreadyExistException;
import com.bsms.exception.ResourceNotFoundException;
import com.bsms.repository.CustomerRepo;
import com.bsms.service.CustomerService;
import com.bsms.util.CustomerConverter;


@Service
public class CustomerSevericeImpl implements CustomerService{
   
	@Autowired
	CustomerRepo custRepo;//injecting Customer repository
	
	@Autowired
	CustomerConverter converter;//injecting the converter which is used to convert entity to dto and vice versa
	
	@Override
	public CustomerDTO createCustomer(Customer customer) {
		List<Customer> customers = custRepo.findAll();
		for(Customer cust: customers)
		{
			if(cust.getCustomerName().equals(customer.getCustomerName()))
			{
				throw new PropertyAlreadyExistException("Customer name already exists.");
			}
			if(cust.getContact().equals(customer.getContact()))
			{
				throw new PropertyAlreadyExistException("Phone number already exists.");
			}
			if(cust.getEmail().equals(customer.getEmail()))
			{
				throw new PropertyAlreadyExistException("Email already exists.");
			}
		}
		
		custRepo.save(customer); //save the Customer details
		return converter.convertToCustDTO(customer);//return Customer details
	}

	//method used to fetch Customer details using Customer id
	@Override
	public CustomerDTO getCustomerById(int id) {
		
		Customer customer = custRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer", "Id", id));
		return converter.convertToCustDTO(customer);
	}

	//method used to get all Customer details
	@Override
	public List<CustomerDTO> getAllCustomers() {

		List<Customer> customers = custRepo.findAll();
		List<CustomerDTO> customerDto = new ArrayList<>();
		for(Customer cust : customers)
		{
			customerDto.add(converter.convertToCustDTO(cust));
		}
		return customerDto;
	}

	@Override
	public CustomerDTO updateCustomerById(int id, Customer customer) {
		Customer existCustomer = custRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer", "Id", id));
		
		//updating the existing Customer details with new details
		existCustomer.setCustomerName(customer.getCustomerName());
		existCustomer.setContact(customer.getContact());
		existCustomer.setPassword(customer.getPassword());
		existCustomer.setCity(customer.getCity());
		existCustomer.setState(customer.getState());
		existCustomer.setCountry(customer.getCountry());
		
		//saving the updated details
		custRepo.save(existCustomer);
		;
		return converter.convertToCustDTO(existCustomer);
	}

	@Override
	public void deleteCustomerById(int id) {
		Optional<Customer> opCustomer = custRepo.findById(id);
		if(opCustomer.isPresent())
		{
			custRepo.deleteById(id);
		}
		else
		{
			throw new ResourceNotFoundException("Customer", "Id", id);
		}
		
	}

	@Override
	public void deleteAllCustomers() {
		
		custRepo.deleteAll();
		
	}

	@Override
	public List<CustomerDTO> getCustomerUsingName(String name) {
		List<Customer> cusatomers = custRepo.getCustomerByName(name);
		List<CustomerDTO> custDto = new ArrayList<>();
		for(Customer c : cusatomers)
		{
			custDto.add(converter.convertToCustDTO(c));		
		}
		return custDto;
	}

	@Override
	public CustomerDTO getCustomerByEmail(String email) {
		Customer cust = custRepo.findByEmail(email);
		if(cust!=null)
		{
		return converter.convertToCustDTO(cust);
		}
		else
		{
			throw new ResourceNotFoundException("Customer", "Email", email);
		}
	}   

}
