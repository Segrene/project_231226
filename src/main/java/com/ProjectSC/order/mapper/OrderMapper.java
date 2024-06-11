package com.ProjectSC.order.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ProjectSC.order.domain.Order;

@Mapper
public interface OrderMapper {

	int insertPreOrder(Order order);

	Order selectPreOrder(int orderId);

	int insertOrder(Order order);

	Order selectOrder(int orderId);

	int deletePreOrder(int orderId);

	Order selectLatestOrder();
	
}
