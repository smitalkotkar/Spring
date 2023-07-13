package com.bsms.service;

import com.bsms.dto.OrderDTO;
import com.bsms.entity.Order;


public interface OrderService {

	 public OrderDTO createOrder(int cakeId,int custId,Order order); //method to create order
	 
	 public OrderDTO getOrderById(int id); //method to retrieve a order

}
