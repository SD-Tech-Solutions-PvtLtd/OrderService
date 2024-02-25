package com.sd.tech.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable{
	
	private int id;
	private String userName;
	private String userPassword;
	private String address;
	private String city;

}
