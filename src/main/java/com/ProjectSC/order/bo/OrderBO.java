package com.ProjectSC.order.bo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectSC.cart.bo.CartBO;
import com.ProjectSC.cart.domain.CartView;
import com.ProjectSC.order.domain.Order;
import com.ProjectSC.order.mapper.OrderMapper;

@Service
public class OrderBO {
	
	@Autowired
	private CartBO cartBO;
	@Autowired
	private OrderMapper orderMapper;
	
	public Order orderPrepare(int userId) {
		Order order = new Order();
		int totalAmount = 0;
		int deliveryFee = 0;
		List<CartView> cartItems = cartBO.getCartList(userId);
		for (CartView cart : cartItems) {
			totalAmount += cart.getProductInfo().getFinalPrice() * cart.getCart().getQty();
			if (cart.getProductInfo().getDeliveryType().equals("당일 배송")) {
				deliveryFee += 3500 * cart.getCart().getQty();
			} else if (cart.getProductInfo().getDeliveryType().equals("즉시 배송")) {
				deliveryFee += 3000 * cart.getCart().getQty();
			} else if (cart.getProductInfo().getDeliveryType().equals("일반 배송")) {
				deliveryFee += 1000 * cart.getCart().getQty();
			}
		}
		order.setUserId(userId);
		order.setAmount(totalAmount);
		order.setDeliveryFee(deliveryFee);
		order.setTotalAmount(totalAmount + deliveryFee);
		orderMapper.insertPreOrder(order);
		return order;
	}
	
	public Order getPreOrder(int orderId) {
		return orderMapper.selectPreOrder(orderId);
	}
	
	public int deletePreOrder(int orderId) {
		return orderMapper.deletePreOrder(orderId);
	}
	
	public Order orderCompletion(Order order) {
		return order;
	}

	public int addOrder(int preOrderId, String address, int paymentMethod, String receiver, String contact,
			String paymentId) {
		Order preOrder = orderMapper.selectPreOrder(preOrderId);
		int userId = preOrder.getUserId();
		int amount = preOrder.getAmount();
		int deliveryFee = preOrder.getDeliveryFee();
		int totalAmount = preOrder.getTotalAmount();
		String status = "결제 확인";
		LocalDateTime estimated = LocalDateTime.now().plusDays(3);
		Order order = new Order();
		order.setUserId(userId);
		order.setAmount(amount);
		order.setDeliveryFee(deliveryFee);
		order.setTotalAmount(totalAmount);
		order.setAddress(address);
		order.setReceiver(receiver);
		order.setContact(contact);
		order.setPaymentMethod(paymentMethod);
		order.setPaymentId(paymentId);
		order.setEstimated(estimated);
		order.setStatus(status);
		orderMapper.insertOrder(order);
		int orderId = order.getId();
		deletePreOrder(preOrderId);
		return orderId;
	}

	public Order getOrder(int orderId) {
		return orderMapper.selectOrder(orderId);
	}

	public Order getLatestOrder(int userId) {
		return orderMapper.selectLatestOrder(userId);
	}
}
