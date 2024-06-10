package com.ProjectSC.order.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ProjectSC.order.domain.Order;

@Mapper
public interface OrderMapper {

	int insertPreOrder(Order order);

	Order selectPreOrder(int orderId);

	void insertOrder(@Param("userId")int userId, @Param("amount")int amount, @Param("deliveryFee")int deliveryFee, 
			@Param("totalAmount")int totalAmount, @Param("address")String address, @Param("receiver")String receiver,
			@Param("contact")String contact, @Param("paymentMethod")int paymentMethod, @Param("paymentId")String paymentId, 
			@Param("estimated")LocalDateTime estimated, @Param("status")String status);
	
}
