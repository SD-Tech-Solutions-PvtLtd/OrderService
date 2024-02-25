package com.sd.tech.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO  implements Serializable{
	
	private int id;
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private int price;
	private int restaurantId;
	private int quantity;

}
