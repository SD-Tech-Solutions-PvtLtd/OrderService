package com.sd.tech.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sd.tech.entity.OrderInfo;

/*@Repository
public interface OrderInfoRepo extends JpaRepository<OrderInfo, Integer>{
*/
@Repository
public interface OrderInfoRepo extends MongoRepository<OrderInfo, Integer>{

}
