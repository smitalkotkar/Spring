package com.bsms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsms.dto.CakeDTO;
import com.bsms.dto.UserDTO;
import com.bsms.entity.Cake;
import com.bsms.entity.User;
import com.bsms.exception.PropertyAlreadyExistException;
import com.bsms.exception.ResourceNotFoundException;
import com.bsms.repository.CakeRepo;
import com.bsms.service.CakeService;
import com.bsms.util.CakeConverter;

@Service
public class CakeServiceImpl implements CakeService {
	
	@Autowired
	CakeRepo cRepo;
	
	@Autowired
	CakeConverter converter;

	@Override
	public CakeDTO createCake(Cake cake) {
		List<Cake> cakes = cRepo.findAll();
		for(Cake c: cakes)
		{
			if(c.getCakeName().equals(cake.getCakeName()))
			{
				throw new PropertyAlreadyExistException("Cake name already exists.");
			}
		}
		
		cRepo.save(cake); //save the cake details
		return converter.convertToCakeDTO(cake);//return cake details 
	} 
	

	//method used to fetch user details using user id
	@Override
	public CakeDTO getCakeById(int id) {
		Cake cake = cRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cake", "Id", id));
		return converter.convertToCakeDTO(cake);
	}

	@Override
	public List<CakeDTO> getAllCakes() {
		List<Cake> cakes = cRepo.findAll();
		List<CakeDTO> cakeDto = new ArrayList<>();
		for(Cake c : cakes)
		{
			cakeDto.add(converter.convertToCakeDTO(c));
		} 
		return cakeDto;
	}

	@Override
	public CakeDTO updateCakeById(int id, Cake cake) {
		Cake existCake = cRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cake", "Id", id));
		
		//updating the existing user details with new details
		existCake.setCakeName(cake.getCakeName());
		existCake.setCakeFlavour(cake.getCakeFlavour());
		existCake.setCakePrize(cake.getCakePrize());
		existCake.setWeight(cake.getWeight());
		
		//saving the updated details
		cRepo.save(existCake);
		;
		return converter.convertToCakeDTO(existCake);
	}

	@Override
	public void deleteCakeById(int id) {
		Optional<Cake> opCake = cRepo.findById(id);
		if(opCake.isPresent())
		{
			cRepo.deleteById(id);
		}
		else
		{
			throw new ResourceNotFoundException("Cake", "Id", id);
		}
		
	}

	@Override
	public void deleteAllCakes() {
		cRepo.deleteAll();
		
	}

	
}