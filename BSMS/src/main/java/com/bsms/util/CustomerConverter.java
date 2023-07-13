package com.bsms.util;

import org.springframework.beans.BeanUtils; 
import org.springframework.stereotype.Component;

import com.bsms.dto.CustomerDTO;
import com.bsms.entity.Customer;


@Component
public class CustomerConverter {
	
	 //convert Customer entity into CustomerDTO
	public CustomerDTO convertToCustDTO(Customer customer)
	{
		CustomerDTO customerDto = new CustomerDTO();
		if(customer!=null)
		{
		  BeanUtils.copyProperties(customer, customerDto);
		}
		return customerDto;
	}
	
	//convert CustomerDTO to Customer entity
	public Customer convertToCustEntity(CustomerDTO customerDto)
	{
		Customer customer = new Customer();
		if(customerDto!=null)
		{
			BeanUtils.copyProperties(customerDto, customer);
		}
		return customer;
	}

}
