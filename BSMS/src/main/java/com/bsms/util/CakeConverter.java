package com.bsms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bsms.dto.CakeDTO;
import com.bsms.entity.Cake;



@Component
public class CakeConverter {

	 //convert employee entity into employeeDTO
		public CakeDTO convertToCakeDTO(Cake cake)
		{
			CakeDTO cakeDto = new CakeDTO();
			if(cake!=null)
			{
			  BeanUtils.copyProperties(cake, cakeDto);
			}
			return cakeDto;
		}
		
		//convert employeeDTO to employee entity
		public Cake convertToCakeEntity(CakeDTO cakeDto)
		{
			Cake cake = new Cake();
			if(cakeDto!=null)
			{
				BeanUtils.copyProperties(cakeDto, cake);
			}
			return cake;
		}
}
