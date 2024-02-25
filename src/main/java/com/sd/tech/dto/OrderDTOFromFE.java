package com.sd.tech.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTOFromFE {
	
	private List<FoodItemDTO> foodItemsList;
	private Integer userId;
	private Restaurant restaurant;
	
	

}
