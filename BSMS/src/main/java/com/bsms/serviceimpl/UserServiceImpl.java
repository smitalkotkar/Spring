package com.bsms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsms.entity.User;
import com.bsms.repository.UserRepo;
import com.bsms.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public User login(String userName, String password) {
		return userRepo.findByUserNameAndPassword(userName, password);
	}

}
