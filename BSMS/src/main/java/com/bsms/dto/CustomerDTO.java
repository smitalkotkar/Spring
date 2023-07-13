package com.bsms.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bsms.entity.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO extends UserDTO {
	
	@NotNull(message="Customer Name cannot be null")
	@NotBlank(message="Customer Name is required")
	@Size(max=20, message="Maximum 20 characters allowed")
	@Size(min=2, message="Minimum 2 values required")
	private String customerName;
	
	@NotNull(message="City cannot be null")
	@NotBlank(message="City  Name is required")
	@Size(max=10, message="Maximum 10 characters allowed")
	@Size(min=2, message="Minimum 2 values required")
	private String city;
	
	@NotNull(message="State cannot be null")
	@NotBlank(message="State  Name is required")
	@Size(max=15, message="Maximum 15 characters allowed")
	@Size(min=2, message="Minimum 2 values required")
	private String state;
	
	@NotNull(message="Country cannot be null")
	@NotBlank(message="Country  Name is required")
	@Size(max=10, message="Maximum 10 characters allowed")
	@Size(min=2, message="Minimum 2 values required")
	private String country; 
	
	@NotNull(message="Phone number cannot be null")
	@NotBlank(message="Phone number is required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}$", message="Phone number should consist of 10 digits")
	private String contact;
	
	@NotNull(message="Email cannot be null")
	@NotBlank(message="Email is required")
	@Email(message="Invalid email")
	private String email;
	
	@OneToOne //at one time a customer can order only once
	private Order order;

}
