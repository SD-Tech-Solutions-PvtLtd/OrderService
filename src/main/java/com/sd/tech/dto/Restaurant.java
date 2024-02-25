package com.sd.tech.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant  implements Serializable{
	
	private int id;
	private String name;
	private String address;
	private String city;
	private String description;


}
