package com.bsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsms.entity.User;

//we are inheriting the CRUD operations

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUserNameAndPassword(String userName, String password);
}
