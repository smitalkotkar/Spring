package com.bsms.dto;
 
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bsms.entity.Cake;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	
	private int orderId;
	
	@NotNull(message="Order quantity couldn't be null")
	private int qty;
	
	@NotNull(message="shippingAddress cannot be null")
	@NotBlank(message="shippingAddress is required")
	private String shippingAddress;
	
	@NotNull(message="Amount couldn't be null")
	private double amount;
	
	//@NotNull(message="Order_status couldn't be null")
	private String order_status;
	
	@OneToOne 
	private Cake cake;


}
