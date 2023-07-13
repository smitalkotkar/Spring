package com.bsms.servicetest;

import static org.assertj.core.api.Assertions.assertThat; 
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bsms.dto.CustomerDTO;
import com.bsms.entity.Customer;
import com.bsms.repository.CustomerRepo;
import com.bsms.service.CustomerService;
import com.bsms.util.CustomerConverter;

@SpringBootTest
public class CustomerServiceTest {
	
	@MockBean
	CustomerRepo custRepo;
	
	@Autowired
	CustomerConverter converter;
	
	@Autowired
	CustomerService custService;
	
	Customer cust;
	
	@BeforeEach
	void setUp() throws Exception {
		 cust = Customer.builder().userName("manisha")
				 .password("mani123")
				 .customerName("Manisha")
				 .city("Sambhajinagar")
				 .state("Maharashtra")
				 .country("India")
				 .contact("9854216325")
				 .email("manisha@gmail.com")
				 .build();
		}
	
	//test method will test create customer method
	@Test
	@DisplayName("Testing save customer method")
	void testCreateCustomer()
	{
		Mockito.when(custRepo.save(cust)).thenReturn(cust);
		assertEquals("Manisha", custService.createCustomer(cust).getCustomerName());
	}
	
	@Test
	@DisplayName("Testing get cust details using id")
	void testGetCustById()
	{
		Optional<Customer> opCust = Optional.of(cust);
		Mockito.when(custRepo.findById(cust.getUserId())).thenReturn(opCust);
		
		CustomerDTO custDto = converter.convertToCustDTO(opCust.get());
		assertThat(custService.getCustomerById(cust.getUserId()).getCustomerName()
				.equals(custDto.getCustomerName()));
	}
	

	@Test
	@DisplayName("Testing update customer method")
	void testUpdateCustomer()
	{
		Optional<Customer> opCust = Optional.of(cust);
		Customer cust2 = opCust.get();
		
		Mockito.when(custRepo.findById(cust.getUserId())).thenReturn(opCust);
		cust2.setCustomerName("Manisha Mane");
		
		Mockito.when(custRepo.save(cust2)).thenReturn(cust2);
		
		assertEquals("Manisha Mane", custService.updateCustomerById(cust2.getUserId(), cust2).getCustomerName());
		
	}
	
	@Test
	@DisplayName("Negative test case")
	void testNegativeGetCustById()
	{
		Optional<Customer> opCust = Optional.of(cust);
		Mockito.when(custRepo.findById(cust.getUserId())).thenReturn(opCust);
		
		assertThat(custService.getCustomerById(cust.getUserId()).getCustomerName())
		.isEqualTo("Asmita");
	}
	
	}


