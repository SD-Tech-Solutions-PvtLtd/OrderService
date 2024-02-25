package com.sd.tech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sd.tech.dto.OrderDTO;
import com.sd.tech.dto.OrderDTOFromFE;
import com.sd.tech.entity.OrderInfo;


public interface OrderInfoService {
	
	// ResponseEntity<OrderInfo> saveOrder(OrderInfo orderInfo);
		
	 ResponseEntity<OrderInfo> getByOrderId(int id);
	 
	 List<OrderInfo> getAllOrders();
	 
	 public OrderDTO saveOrderInDB(OrderDTOFromFE dtoFromFE);
 
	
	
	
	
	
	
	
	
	
	
	 

}
