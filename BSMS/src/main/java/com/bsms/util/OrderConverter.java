package com.bsms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bsms.dto.OrderDTO;
import com.bsms.entity.Order;

@Component
public class OrderConverter {
	
	 //convert Order entity into OrderDTO
		public OrderDTO convertToOrderDTO(Order order)
		{
			OrderDTO orderDto = new OrderDTO();
			if(order!=null)
			{
			  BeanUtils.copyProperties(order, orderDto);
			}
			return orderDto;
		}
		
		//convert OrderDTO to Order entity
		public Order convertToOrderEntity(OrderDTO orderDto)
		{
			Order order = new Order();
			if(orderDto!=null)
			{
				BeanUtils.copyProperties(orderDto, order);
			}
			return order;
		}

}
