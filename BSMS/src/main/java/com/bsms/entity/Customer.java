package com.bsms.entity;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer extends User {
	
	@Column(length=20, nullable = false)
	private String customerName;
	
	@Column(length=10, nullable = false)
	private String city;
	
	@Column(length=15, nullable = false)
	private String state;
	
	@Column(length=10, nullable = false)
	private String country;
	
	@Column(length=10, nullable = false, unique = true)
	private String contact;
	
	@Column(length=30, nullable = false, unique=true)
	private String email;
	
	@OneToOne
	private Order order;
	
    @Builder
	public Customer(int userId, String userName, String password, String customerName, String city, String state,
			String country, String contact, String email, Order order) {
		super(userId, userName, password);
		this.customerName = customerName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contact = contact;
		this.email = email;
		this.order = order;
	}
	
	
}
