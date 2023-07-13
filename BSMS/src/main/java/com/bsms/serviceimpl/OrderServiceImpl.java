package com.bsms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsms.dto.OrderDTO;
import com.bsms.entity.Cake;
import com.bsms.entity.Customer;
import com.bsms.entity.Order;
import com.bsms.exception.ResourceNotFoundException;
import com.bsms.repository.CakeRepo;
import com.bsms.repository.CustomerRepo;
import com.bsms.repository.OrderRepo;
import com.bsms.service.OrderService;
import com.bsms.util.OrderConverter;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepo orderRepo;//injecting Order repository

	@Autowired
	OrderConverter converter;//injecting the converter which is used to convert entity to dto and vice versa
	
	@Autowired
	CakeRepo cakeRepo;
	
	@Autowired
	CustomerRepo custRepo;

	@Override
	public OrderDTO createOrder(int cakeId,int custId, Order order){
		Cake cake=cakeRepo.findById(cakeId).get();
		Customer cust =custRepo.findById(custId).get();
		order.setAmount(order.getQty()*cake.getCakePrize());
		order.setOrder_status("Order Placed");
		order.setCake(cake);
		orderRepo.save(order); //save the Order details
		cust.setOrder(order);
		custRepo.save(cust);
		
		return converter.convertToOrderDTO(order);//return Order details
	}


	@Override
	public OrderDTO getOrderById(int id) {
		
		Order order = orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order", "Id", id));
		return converter.convertToOrderDTO(order);
	}
		
		

}
