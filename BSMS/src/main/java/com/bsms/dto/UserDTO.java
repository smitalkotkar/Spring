package com.bsms.dto;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	@Id
	private int userId;
	
	@NotNull(message="Username cannot be null")
	@NotBlank(message="Username is required")
	@Size(max=20, message="Maximum 20 characters allowed")
	@Size(min=2, message="Minimum 2 values required")
//	@Email(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",flags = Pattern.Flag.CASE_INSENSITIVE, message = "User name must be a well-formed email address!")
	private String userName;
	
	
	@NotNull(message="Password cannot be null")
	@NotBlank(message="Password is required")
	@Size(max=20, message="Maximum 20 characters allowed")
	@Size(min=4, message="Minimum 4 values required")
	private String password;
	
}

