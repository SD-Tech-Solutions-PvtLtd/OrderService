package com.sd.tech.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sd.tech.dto.OrderDTO;
import com.sd.tech.dto.OrderDTOFromFE;
import com.sd.tech.dto.UserDTO;
import com.sd.tech.entity.OrderInfo;
import com.sd.tech.repository.OrderInfoRepo;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

	@Autowired
	private OrderInfoRepo orderInfoRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ModelMapper mapper;
	
	    @Autowired
	    SequenceGenerator sequenceGenerator;

	/*
	 * @Override public ResponseEntity<OrderInfo> saveOrder(OrderInfo orderInfo) {
	 * 
	 * if (orderInfo != null) { OrderInfo savedOrder =
	 * orderInfoRepo.saveAndFlush(orderInfo); return new
	 * ResponseEntity<>(savedOrder, org.springframework.http.HttpStatus.OK); } else
	 * { return new ResponseEntity<>(null,
	 * org.springframework.http.HttpStatus.BAD_REQUEST); }
	 * 
	 * }
	 */

	@Override
	public ResponseEntity<OrderInfo> getByOrderId(int id) {

		
		
		Optional<OrderInfo> findById = orderInfoRepo.findById(id);
		OrderInfo orderData = findById.get();

		if (orderData != null) {
			return new ResponseEntity<>(orderData, org.springframework.http.HttpStatus.FOUND);

		} else {
			return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * @Override public OrderDTO saveOrderInDB(OrderDTOFromFE dtoFromFE) { UserDTO
	 * userDetailsFromUserId = fetchUserDetailsFromUserId(dtoFromFE.getUserId());
	 * 
	 * OrderInfo order = new OrderInfo(1,dtoFromFE.getFoodItemsList(),
	 * dtoFromFE.getRestaurant(), userDetailsFromUserId);
	 * 
	 * 
	 * OrderInfo order =new OrderInfo();
	 * order.setFoodItemsList(dtoFromFE.getFoodItemsList());
	 * order.setRestaurant(dtoFromFE.getRestaurant());
	 * order.setUserDTO(userDetailsFromUserId);
	 * 
	 * OrderDTO orderDTO = mapper.map(order, OrderDTO.class);
	 * orderInfoRepo.save(order);
	 * 
	 * return orderDTO; }
	 */
	
	@Override
	public OrderDTO saveOrderInDB(OrderDTOFromFE dtoFromFE) {
		System.out.println(" inside >>>> saveOrderInDB  >>>>>>> ");
		
		 Integer newOrderID = sequenceGenerator.generateNextOrderId();
		 System.out.println("newOrderID generated  ... "+newOrderID);
		 
		UserDTO userDetailsFromUserId = fetchUserDetailsFromUserId(dtoFromFE.getUserId());
		/*
		 * OrderInfo order = new OrderInfo(1,dtoFromFE.getFoodItemsList(),
		 * dtoFromFE.getRestaurant(), userDetailsFromUserId);
		 */
		
		OrderInfo order =new OrderInfo();
		order.setOrderId(newOrderID);
		order.setFoodItemsList(dtoFromFE.getFoodItemsList());
		order.setRestaurant(dtoFromFE.getRestaurant());
		order.setUserDTO(userDetailsFromUserId);

		OrderDTO orderDTO = mapper.map(order, OrderDTO.class);
		System.out.println("before saving >>> mongo data >>>>> ");
		orderInfoRepo.save(order);

		return orderDTO;
	}

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		System.out.println("entered user id:: "+userId );

		return restTemplate.getForObject("http://UserInfo-Service/userinfo/fetchUserById/"+userId, UserDTO.class);
	}

	@Override
	public List<OrderInfo> getAllOrders() {
		return orderInfoRepo.findAll();

	}

}
