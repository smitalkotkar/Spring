package com.bsms.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsms.dto.CustomerDTO;
import com.bsms.dto.OrderDTO;
import com.bsms.entity.Order;
import com.bsms.service.OrderService;
import com.bsms.util.OrderConverter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class OrderController {


	@Autowired
	OrderService orderService;//injecting Order repository
 
	@Autowired
	OrderConverter converter;//injecting the converter which is used to convert entity to dto and vice versa
	
	//build save method using REST API
	@PostMapping("/order/{cakeId}/{custId}")
	public OrderDTO createOrder(@PathVariable("cakeId") int cakeId,@PathVariable("custId") int custId, @RequestBody @Valid OrderDTO orderDto)
	{
		final Order order = converter.convertToOrderEntity(orderDto);
		return orderService.createOrder(cakeId, custId, order);
	}
	
	//build get orders details using id REST API
	@GetMapping("/order/{orderId}")
	public  OrderDTO getOrderById(@PathVariable("orderId") int id)
	{
	    return  orderService.getOrderById(id);
	 }
	

}

