package com.bsms.entity;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(nullable = false)
	private int qty;
	
	@Column(length=50, nullable = false)
	private String shippingAddress;
	
	@Column(nullable = false)
	private double amount;
	
	@Column(length=20, nullable = false)
	private String order_status;
	
	@OneToOne 
	private Cake cake;

}

