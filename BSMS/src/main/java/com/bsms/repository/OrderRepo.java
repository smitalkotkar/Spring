package com.bsms.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.bsms.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>  {

}
