package com.bsms.controller;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsms.dto.CakeDTO;
import com.bsms.entity.Cake;
import com.bsms.service.CakeService;
import com.bsms.util.CakeConverter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class CakeController {

	@Autowired
	CakeService cService;
	
	@Autowired
	CakeConverter cakeConverter;
	
	@PostMapping("/cake")
	public CakeDTO createCake(@RequestBody @Valid CakeDTO cakeDto)
	{
		final Cake cake = cakeConverter.convertToCakeEntity(cakeDto);
		return cService.createCake(cake);
	}
	
	
	@GetMapping("/cake/{cakeid}")
	public  CakeDTO getCakeById(@PathVariable("cakeId") int id)
	{
		return  cService.getCakeById(id);
	}
	
	
	
	@GetMapping("/cakes")
	public List<CakeDTO> getAllCakes()
	{
		return cService.getAllCakes();
	}
	
	
	@PutMapping("/cake/{cakeId}")
	public CakeDTO updateCakeById(@PathVariable("custId") int cakeId, @Valid @RequestBody CakeDTO cakeDto)
	{
		final Cake cake = cakeConverter.convertToCakeEntity(cakeDto);
		return cService.updateCakeById(cakeId, cake);
	}
	
	//Delete mapping to delete all the cakes
	@DeleteMapping("/cake/{cakeId}")
	public ResponseEntity<String> deleteCakeById(@PathVariable("cakeId") int cakeId)
	{
		cService.deleteCakeById(cakeId);
		   return new ResponseEntity<String>("Cake details with id"+cakeId+" deleted succussfully.", HttpStatus.OK);
	}
			
	public ResponseEntity<String> deleteAllCakes()
	{
	    cService.deleteAllCakes();
		return new ResponseEntity<String>("All cake details deleted successfully.",HttpStatus.OK);
	}
		
	
	
}