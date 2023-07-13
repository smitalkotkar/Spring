package com.bsms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cake {
	
	@Id
	private int cakeId;
	
	@Column(length=20, nullable = false)
	private String cakeName;
	
	@Column(length=20, nullable = false)
	private String cakeFlavour;
	
	@Column(nullable = false)
	private double cakePrize;
	
	@Column(nullable = false)
	private int weight;
	
	@OneToOne
	private Order order;
	

}