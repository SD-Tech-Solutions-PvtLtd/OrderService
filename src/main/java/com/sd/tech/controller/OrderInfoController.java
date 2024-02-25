package com.sd.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sd.tech.dto.OrderDTO;
import com.sd.tech.dto.OrderDTOFromFE;
import com.sd.tech.entity.OrderInfo;
import com.sd.tech.service.OrderInfoService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;

	// ResponseEntity<OrderInfo> savedOrderInfo;
	ResponseEntity<OrderInfo> orderInfo;
	OrderDTO saveOrderInDB;

	/*
	 * @PostMapping("/save") public ResponseEntity<OrderInfo> saveOrder(@RequestBody
	 * OrderInfo orderInfo) { try { savedOrderInfo =
	 * orderInfoService.saveOrder(orderInfo); }catch (Exception e) {
	 * System.out.println(e.getMessage()); }
	 * 
	 * return savedOrderInfo;
	 * 
	 * }
	 */
	@PostMapping("/save")
	public OrderDTO saveOrderInDataBase(@RequestBody OrderDTOFromFE orderInfo) {
		try {
			System.out.println("before saving and processing data "+orderInfo);
			saveOrderInDB = orderInfoService.saveOrderInDB(orderInfo);
			System.out.println("**** ... **** after processing request data "+saveOrderInDB);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return saveOrderInDB;

	}

	@GetMapping("/findById")
	public ResponseEntity<OrderInfo> getByOrderId(@RequestParam int id) {
		try {
			orderInfo = orderInfoService.getByOrderId(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return orderInfo;

	}

	@GetMapping("/getAll")
	public List<OrderInfo> getAllOrders() {
		return orderInfoService.getAllOrders();

	}

}
