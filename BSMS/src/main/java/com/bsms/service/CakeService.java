package com.bsms.service;

import java.util.List; 

import com.bsms.dto.CakeDTO;
import com.bsms.entity.Cake;

public interface CakeService {
	
	public CakeDTO createCake(Cake cake); //method to create a cake
	
	public CakeDTO getCakeById(int id); //method to retrieve a cake
	
	public List<CakeDTO>getAllCakes(); //method to retrieve all cakes
	
	public CakeDTO updateCakeById(int id, Cake cake); //method to update a cake
	
	void deleteCakeById(int id); //method to delete a cake
	
	void deleteAllCakes(); //method to delete all cakes

}
