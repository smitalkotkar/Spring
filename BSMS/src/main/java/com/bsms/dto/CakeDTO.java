package com.bsms.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CakeDTO {
	
	@Id
	private int cakeId;
	
	@NotBlank(message="Cake name can't be empty")
    @NotNull(message="Cake name can't be null")
	private String cakeName;
	
	@NotBlank(message="Cake flavour can't be empty")
	@NotNull(message="Cake flavour can't be null")
	private String cakeFlavour;
	
	@NotNull(message="Cake amount couldn't be null")
	private double cakePrize;
	
	@NotNull(message="Cake weight couldn't be null")
	private int weight;

}
