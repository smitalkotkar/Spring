package com.bsms.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsms.service.UserService;
import com.bsms.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
	

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String validate(@RequestBody User user) throws ServletException
	{
		String jwtToken="";
		
		if(user.getUserName()==null && user.getPassword()==null)
		{
			throw new ServletException("Please fill in userName and password");
		}
		
		user = userService.login(user.getUserName(), user.getPassword());
		
		if(user==null)
		{
			throw new ServletException("User details not found!");
		}
		
		
		jwtToken = Jwts.builder().setSubject(user.getUserName())
		.claim("customer", user.getUserName().getClass())
		.signWith(SignatureAlgorithm.HS256, "secretkey")
		.compact();
		
		return jwtToken;
	}
	
	

}
