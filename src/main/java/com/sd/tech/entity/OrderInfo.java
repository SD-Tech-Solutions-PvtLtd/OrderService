package com.sd.tech.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import com.sd.tech.dto.FoodItemDTO;
import com.sd.tech.dto.Restaurant;
import com.sd.tech.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entit
@Document(collection = "order")
public class OrderInfo {
	 
	private Integer orderId;
	private List<FoodItemDTO> foodItemsList;
	private Restaurant restaurant;
	private UserDTO userDTO;

}
